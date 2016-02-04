package ru.scrumtrek.trainings.icpprg.badcode;

import java.util.*;

public class NestedConditionsAndDuplicateCode {

    private List<String> getHeadings(List<String> headings, TypeParams params) {

        List<String> toReturn = new ArrayList<String>();

        for (String type : headings) {
            if (!type.equals(getResources().getStringArray(R.array.red_flag_arrays)[0])) {
                if (getResources().getStringArray(R.array.red_flag_arrays)[1].equals(type)) {
                    type = type + OPEN + params.getProblemSize() + CLOSE;
                    toReturn.add(type);
                } else if (getResources().getStringArray(R.array.red_flag_arrays)[2].equals(type)) {
                    type = type + OPEN + params.getCompetitorSize() + CLOSE;
                    toReturn.add(type);
                } else if (getResources().getStringArray(R.array.red_flag_arrays)[3].equals(type)) {
                    type = type + OPEN + params.getRobberySize() + CLOSE;
                    toReturn.add(type);
                } else if (getResources().getStringArray(R.array.red_flag_arrays)[4].equals(type)) {
                    type = type + OPEN + params.getInjurySize() + CLOSE;
                    toReturn.add(type);
                } else if (getResources().getStringArray(R.array.red_flag_arrays)[5].equals(type)) {
                    type = type + OPEN + params.getSickSize() + CLOSE;
                    toReturn.add(type);
                } else if (getResources().getStringArray(R.array.red_flag_arrays)[6].equals(type)) {
                    type = type + OPEN + params.getDamagedSize() + CLOSE;
                    toReturn.add(type);
                } else if (getResources().getStringArray(R.array.red_flag_arrays)[7].equals(type)) {
                    type = type + OPEN + params.getNoStockSize() + CLOSE;
                    toReturn.add(type);
                }
            }
        }

        return toReturn;
    }









































    //--------------------------------------------------------------------------//

    private static String OPEN = "<p>";
    private static String CLOSE = "</p>";
    private ResourceBundle resources;

    public ResourceBundle getResources() {
        return resources;
    }

    private static class R {

        public static Array array;

        class Array {
            public String red_flag_arrays;
        }
    }

    private class TypeParams {
        private String problemSize;
        private String competitorSize;
        private String robberySize;
        private String injurySize;
        private String sickSize;
        private String damagedSize;
        private String noStockSize;

        public String getProblemSize() {
            return problemSize;
        }

        public String getCompetitorSize() {
            return competitorSize;
        }

        public String getRobberySize() {
            return robberySize;
        }

        public String getInjurySize() {
            return injurySize;
        }

        public String getSickSize() {
            return sickSize;
        }

        public String getDamagedSize() {
            return damagedSize;
        }

        public String getNoStockSize() {
            return noStockSize;
        }
    }
}
