package com.example.Medical.Specification;

import com.example.Medical.entity.Doctor;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.List;

public class DoctorSpecification {

    public static Specification<Doctor> hasSpecialization(String specialization) {
        return (root, query, criteriaBuilder) ->
                specialization == null ? null : criteriaBuilder.equal(root.get("specialization"), specialization);
    }

    public static Specification<Doctor> hasLocation(String city, String locality) {
        return (root, query, criteriaBuilder) -> {
            if (city != null && locality != null) {
                return criteriaBuilder.and(
                        criteriaBuilder.equal(root.get("city"), city),
                        criteriaBuilder.equal(root.get("locality"), locality)
                );
            } else if (city != null) {
                return criteriaBuilder.equal(root.get("city"), city);
            } else if (locality != null) {
                return criteriaBuilder.equal(root.get("locality"), locality);
            }
            return null;
        };
    }

    public static Specification<Doctor> isAvailable(Boolean available) {
        return (root, query, criteriaBuilder) ->
                available == null ? null : criteriaBuilder.equal(root.get("available"), available);
    }

    public static Specification<Doctor> hasAvailability(String availableOption, LocalDateTime chosenDate) {
        return (root, query, criteriaBuilder) -> {
            if (availableOption == null) {
                return null;
            }

            switch (availableOption) {
                case "anytime":
                    return criteriaBuilder.equal(root.get("available"), true);

                case "next_two_hours":
                    LocalDateTime now = LocalDateTime.now();
                    LocalDateTime twoHoursLater = now.plusHours(2);
                    return criteriaBuilder.and(
                            criteriaBuilder.equal(root.get("available"), true),
                            criteriaBuilder.greaterThanOrEqualTo(root.get("availabilityTime"), now),
                            criteriaBuilder.lessThanOrEqualTo(root.get("availabilityTime"), twoHoursLater)
                    );

                case "today":
                    LocalDateTime todayStart = LocalDateTime.now().toLocalDate().atStartOfDay();
                    LocalDateTime todayEnd = todayStart.plusDays(1).minusNanos(1);
                    return criteriaBuilder.and(
                            criteriaBuilder.equal(root.get("available"), true),
                            criteriaBuilder.greaterThanOrEqualTo(root.get("availabilityTime"), todayStart),
                            criteriaBuilder.lessThanOrEqualTo(root.get("availabilityTime"), todayEnd)
                    );

                case "tomorrow":
                    LocalDateTime tomorrowStart = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
                    LocalDateTime tomorrowEnd = tomorrowStart.plusDays(1).minusNanos(1);
                    return criteriaBuilder.and(
                            criteriaBuilder.equal(root.get("available"), true),
                            criteriaBuilder.greaterThanOrEqualTo(root.get("availabilityTime"), tomorrowStart),
                            criteriaBuilder.lessThanOrEqualTo(root.get("availabilityTime"), tomorrowEnd)
                    );

                case "choose_date":
                    if (chosenDate != null) {
                        return criteriaBuilder.and(
                                criteriaBuilder.equal(root.get("available"), true),
                                criteriaBuilder.equal(root.get("availabilityTime"), chosenDate)
                        );
                    }
                    return null;

                default:
                    return null;
            }
        };
    }

    public static Specification<Doctor> hasExperience(Integer minExperience) {
        return (root, query, criteriaBuilder) ->
                (minExperience == null || minExperience <= 0) ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("experience"), minExperience);
    }

    public static Specification<Doctor> hasFeeRange(Double minFee, Double maxFee) {
        return (root, query, criteriaBuilder) -> {
            if (minFee == null || maxFee == null || minFee <= 0 || maxFee <= 0) {
                return null;
            }
            return criteriaBuilder.between(root.get("fee"), minFee, maxFee);
        };
    }

    public static Specification<Doctor> hasRating(Double minRating) {
        return (root, query, criteriaBuilder) -> {
            if (minRating == null || minRating <= 0) {
                return null; // If minRating is null or less than 0, no filter is applied.
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("rating"), minRating);
        };
    }

    public static Specification<Doctor> hasGender(String gender) {
        return (root, query, criteriaBuilder) ->
                gender == null ? null : criteriaBuilder.equal(root.get("gender"), gender);
    }

    public static Specification<Doctor> treatsSymptoms(List<String> symptoms) {
        return (root, query, criteriaBuilder) -> {
            if (symptoms == null || symptoms.isEmpty()) {
                return null;
            }
            return root.get("symptoms").in(symptoms);
        };
    }

    public static Specification<Doctor> worksAtClinic(String clinicName) {
        return (root, query, criteriaBuilder) ->
                clinicName == null ? null : criteriaBuilder.equal(root.get("clinicName"), clinicName);
    }

    public static Specification<Doctor> hasConsultationType(String consultationType) {
        return (root, query, criteriaBuilder) ->
                consultationType == null ? null : criteriaBuilder.equal(root.get("consultationType"), consultationType);
    }
}
