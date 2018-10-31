package by.it.basumatarau.project.java.commands;

class RegExPatterns {
    final static String VENUE_NAME = "([-_А-Яа-яЁё\\w\\d ]{1,90})";
    final static String VENUE_DESCRIPTION = "([-_А-Яа-яЁё\\w\\d ]{1,90})";
    final static String VENUE_FEE = "([.,\\d]{1,60})";
    final static String PLACE_NAME = "([-_А-Яа-яЁё\\w\\d,. ]{1,40})";
    final static String ADDRESS = "([-_А-Яа-яЁё\\w\\d,. ]{1,40})";
    final static String DATE_TIME = "\\s*\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\s*";
    final static String EMAIL_REG_EXP = "([-_А-Яа-яЁё\\w\\d]{1,40})@([-_А-Яа-яЁё\\w\\d]{1,20}).([-_А-Яа-яЁё\\w\\d]{1,4})";
    final static String LOGIN_REG_EXP = "([-_А-Яа-яЁё\\w\\d]{1,60})";
    final static String PASSWORD = "[-_+\\d\\w]+";
}
