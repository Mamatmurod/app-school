package ai.ecma.school.entity;

import ai.ecma.school.entity.template.AbsUUIDUserAuditEntity;
import ai.ecma.school.enums.EnglishLevelEnum;
import ai.ecma.school.enums.GenderEnum;
import ai.ecma.school.enums.StudentStatusEnum;
import ai.ecma.school.payload.UserDTO;
import ai.ecma.school.utils.ColumnKey;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang.ObjectUtils;
import org.hibernate.Hibernate;
import org.hibernate.annotations.*;
import org.hibernate.type.SqlTypes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static ai.ecma.school.utils.TableNameConstant.STUDENT;

/**
 * This class not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 20.01.2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SQLDelete(sql = ("update " + STUDENT + " set deleted=true where id=?"))
@Where(clause = "deleted=false")
@Entity(name = STUDENT)
@FieldNameConstants
public class Student extends AbsUUIDUserAuditEntity implements Cloneable {

    @Column(name = ColumnKey.USER_ID, nullable = false)
    private UUID userId;

    @Column(name = ColumnKey.FIRST_NAME)
    private String firstName;

    @Column(name = ColumnKey.LAST_NAME)
    private String lastName;

    @Column(name = ColumnKey.PATRON)
    private String patron;

    @Column(name = ColumnKey.PHONE_NUMBER, nullable = false)
    private String phoneNumber;

    @Column(name = ColumnKey.PHOTO_ID)
    private String photoId;

    @Column(name = ColumnKey.TURNIKET_ID)
    private String turniketId;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;


    //STUDENT INFO NI TO'LDIRISH UCHUN FIELD LAR
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "interested_ourse", columnDefinition = "bigint[]")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private Long[] interestedCourse;

    @Enumerated(EnumType.STRING)
    private EnglishLevelEnum englishLevel;

    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StudentStatusEnum status = StudentStatusEnum.STUDENT;

    @Column(name = "address", columnDefinition = "bigint[]")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private Long[] address;
    //STUDENT INFO NI TO'LDIRISH UCHUN FIELD LAR

    //SHU STUDENTNING OTA ONAI KIRIB CHIQISHI UCHUN DOIMIY MEHMON ID SI
    //KIDS UCHUN ASOSAN
    @Column(name = "parent_guest_id")
    private String parentGuestId;

    @Column(name = "parent_phone_number")
    private String parentPhoneNumber;

    @ManyToOne
    private Group classes;

    public Student(String firstName, String lastName, String patron, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patron = patron;
        this.phoneNumber = phoneNumber;
    }

    public Student(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Student(UserDTO userDTO) {
        this.userId = userDTO.getId();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.patron = userDTO.getPatron();
        this.phoneNumber = userDTO.getPhoneNumber();
    }

    public String getFullName() {
        return (ObjectUtils.defaultIfNull(firstName, "") + " " + ObjectUtils.defaultIfNull(lastName, "")).trim();
    }

    public List<Long> getInterestedCourse() {
        if (Objects.nonNull(interestedCourse))
            return new ArrayList<>(List.of(interestedCourse));
        return new ArrayList<>();
    }

    public void setInterestedCourse(List<Long> interestedCourse) {
        if (Objects.nonNull(interestedCourse))
            this.interestedCourse = interestedCourse.toArray(new Long[0]);
        else
            this.interestedCourse = null;
    }

    public List<Long> getAddress() {
        if (Objects.nonNull(address))
            return new ArrayList<>(List.of(address));
        return new ArrayList<>();
    }

    public void setAddress(List<Long> address) {
        if (Objects.nonNull(address))
            this.address = address.toArray(new Long[0]);
        else
            this.address = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return getId() != null && Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public Student clone() {
        try {
            Student clone = (Student) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
