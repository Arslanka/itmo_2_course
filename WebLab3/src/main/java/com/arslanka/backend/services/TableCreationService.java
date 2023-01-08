package com.arslanka.backend.services;

import java.sql.SQLException;
import java.util.List;

import com.arslanka.backend.models.daos.Request;
import com.arslanka.backend.models.daos.TableRow;
import com.arslanka.backend.models.daos.Tap;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("tableCreationService")
@ApplicationScoped
public class TableCreationService {
    @Inject
    private RequestService requestService;

    @Inject
    private TableRow tableRow;

    public List<TableRow> getRequestTable(Tap tap) throws SQLException {
        List<Request> requestList = requestService.findRequestsBySessionId(tap.getSessionId());
        if (!requestList.isEmpty()) {
            setTableRow(requestList.get(requestList.size() - 1));
        }
        return requestList.stream().map(Request::toTableRow).toList();
    }

    private void setTableRow(Request request) {
        tableRow.setId(request.getId());
        tableRow.setPoint2D(request.getPoint2D());
        tableRow.setRadius(request.getRadius());
        tableRow.setHit(request.getHit());
        tableRow.setRequestTime(request.getRequestTime());
    }
}
