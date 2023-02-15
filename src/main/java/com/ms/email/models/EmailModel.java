package com.ms.email.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;
import org.hibernate.type.descriptor.java.UUIDJavaType;

import com.ms.email.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "history_email")
public class EmailModel  implements Serializable{
    // private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "email_id")
    private UUID emailId;

    @Column(name = "owner_ref")
    private String ownerRef;

    @Column(name = "email_from")
    private String emailFrom;

    @Column(name = "email_to")
    private String emailTo;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text")
    private String text;

    @Column(name = "send_date_email")
    private LocalDateTime sendDateEmail;

    @Column(name = "status_email")
    private StatusEmail statusEmail;

    public void setSendDateEmail(LocalDateTime now) {
        this.sendDateEmail = now;
    }

   
}
