package com.arslanka.backend.controllers;

import java.sql.SQLException;
import java.util.List;

import com.arslanka.backend.models.daos.Request;
import com.arslanka.backend.models.daos.Table;
import com.arslanka.backend.models.daos.TableRow;
import com.arslanka.backend.models.daos.Tap;
import com.arslanka.backend.services.TableCreationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("tableRequestController")
@ApplicationScoped
public class TableRequestController {

    @Inject
    private TableCreationService tableCreationService;

    @Inject
    private Tap tap;

    public List<TableRow> getTable() throws SQLException {
        try {
            return tableCreationService.getRequestTable(tap);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
