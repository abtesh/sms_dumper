package com.anbesabank.sms_db_dumper.Repositories.PostgresRepo;

import com.anbesabank.sms_db_dumper.Entities.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresDepositRepository extends JpaRepository<Deposit, String> {
}
