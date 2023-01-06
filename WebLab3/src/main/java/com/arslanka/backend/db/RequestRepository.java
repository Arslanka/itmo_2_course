package com.arslanka.backend.db;

import java.sql.SQLException;
import java.util.Collection;

import com.arslanka.backend.models.Point2D;
import com.arslanka.backend.models.Request;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.jooq.SQLDialect;
import org.jooq.sources.tables.records.RequestsRecord;

import static org.jooq.sources.tables.Requests.REQUESTS;

@Named("RequestRepository")
@ApplicationScoped
public class RequestRepository extends SimpleRepository {
    @Inject
    private Request request;
    public static final SQLDialect DB_TYPE_POSTGRESQL = SQLDialect.POSTGRES;

    public Collection<Request> findAllRequests() throws SQLException {
        return withConnection(db -> db.selectFrom(REQUESTS).fetch(this::toRequest), DB_TYPE_POSTGRESQL);
    }

    public void insert() throws SQLException {
        withConnection(db ->
                db.insertInto(REQUESTS, REQUESTS.fields())
                        .valuesOfRecords(request.toRecord())
                        .returning()
                        .fetchSingle(), DB_TYPE_POSTGRESQL);
    }

    private Request toRequest(RequestsRecord record) {
        return new Request(record.getId(),
                new Point2D(record.getXCoor(), record.getYCoor()),
                record.getRadius(),
                record.getRequestTimestamp(), record.getHit());
    }

}
