package com.anbesabank.sms_db_dumper.Service;

import java.util.Date;

public interface TimestampedEntity {
    Date getTransactionDate();
    String getTransactionTime();
}
