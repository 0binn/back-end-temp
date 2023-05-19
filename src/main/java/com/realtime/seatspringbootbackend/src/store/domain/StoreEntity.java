package com.realtime.seatspringbootbackend.src.store.domain;

import com.realtime.seatspringbootbackend.src.global.StateEnum;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "store")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    // user

    @Column(name = "floor_plan_url", nullable = true)
    private String floorPlanUrl;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "introduction", nullable = false)
    private String introduction;

    @Column(name = "total_floor", nullable = false)
    private int totalFloor;

    @Column(name = "day_off", nullable = true)
    private String dayOff;

    @Column(name = "mon_business_hours", nullable = true)
    private String monBusinessHours;

    @Column(name = "tue_business_hours", nullable = true)
    private String tueBusinessHours;

    @Column(name = "wed_business_hours", nullable = true)
    private String wedBusinessHours;

    @Column(name = "thu_business_hours", nullable = true)
    private String thuBusinessHours;

    @Column(name = "fri_business_hours", nullable = true)
    private String friBusinessHours;

    @Column(name = "sat_business_hours", nullable = true)
    private String satBusinessHours;

    @Column(name = "sun_business_hours", nullable = true)
    private String sunBusinessHours;

    @Column(name = "memo", nullable = true)
    private String memo;

    @Enumerated(EnumType.STRING)
    @Column(name = "kind", nullable = false)
    private KindEnum kind;

    @Column(name = "avg_use_time", nullable = false)
    private int avgUseTime;

    @Column(name = "break_time", nullable = true)
    private String breakTime;

    @Column(name = "use_time_limit", nullable = true)
    private int useTimeLimit;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private StateEnum state;

}
