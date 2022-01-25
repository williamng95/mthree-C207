package com.sg.classroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {
    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        try (PrintWriter out = new PrintWriter(new FileWriter(AUDIT_FILE, true))) {
            out.println(String.format("%s : %s", LocalDateTime.now().toString(), entry));
            out.flush();
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("unable to persist audit info");
        }
        
    }
    
}
