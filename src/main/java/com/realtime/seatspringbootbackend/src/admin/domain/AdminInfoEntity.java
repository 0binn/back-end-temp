package com.realtime.seatspringbootbackend.src.admin.domain;

import com.realtime.seatspringbootbackend.common.entity.BaseEntity;
import com.realtime.seatspringbootbackend.src.user.domain.User;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="admin_info")
public class AdminInfoEntity extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name="id", nullable = false)
    private Long adminInfoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="employer_id_number", nullable = false)
    private String employerIdNumber;

    @Column(name = "open_date", nullable = false)
    private LocalDate openDate;

    @Column(name = "admin_name", nullable = false)
    private String adminName;

    @Builder
    public AdminInfoEntity(User user, String employerIdNumber,LocalDate openDate, String adminName){
        this.user=user;
        this.employerIdNumber=employerIdNumber;
        this.openDate=openDate;
        this.adminName=adminName;
    }
}
