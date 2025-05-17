package com.example.DAO;
import com.example.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDAO extends JpaRepository<Notification, Integer>
{
}