package com.anbesabank.sms_db_dumper.Repositories.PostgresRepo;

import com.anbesabank.sms_db_dumper.Entities.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresWithdrawRepository extends JpaRepository<Withdraw, String> {
}
