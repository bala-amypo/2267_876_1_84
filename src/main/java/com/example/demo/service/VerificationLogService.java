package com.example.demo.service;

import com.example.demo.model.VerificationLog;
import java.util.List;

public interface VerificationLogService {

    VerificationLog create(VerificationLog log);

    VerificationLog getById(Long id);

    List<VerificationLog> getByServiceEntry(Long serviceEntryId);
}
