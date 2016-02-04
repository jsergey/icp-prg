package ru.scrumtrek.trainings.icpprg.badcode;

public class DateValidation {

// check that it is valid format
//    d,m,y
//    m,y
//    y
    public boolean validate(Integer nYearFrom, Integer nMonthFrom, Integer nDayFrom, Integer nYearTo, Integer nMonthTo, Integer nDayTo) {

        if ((nYearFrom != null && nMonthFrom != null && nDayFrom != null ||
                nYearFrom != null && nMonthFrom != null ||
                nYearFrom != null) &&
                (nYearTo != null && nMonthTo != null && nDayTo != null ||
                        nYearTo != null && nMonthTo != null ||
                        nYearTo != null)) {

            return true;
        }
        return false;
    }
//    After a short thinking, this condition can be simplified to:
//            if (nYearFrom != null && nYearTo != null)
}
