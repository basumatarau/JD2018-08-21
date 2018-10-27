package by.it.basumatarau.project.java.commands;

class RegExPatterns {
    final static String venueName = "([-_А-Яа-яЁё\\w\\d ]{1,90})";
    final static String venueDescription = "([-_А-Яа-яЁё\\w\\d ]{1,90})";
    final static String venueFee = "([.,\\d]{1,60})";
    final static String placeName = "([-_А-Яа-яЁё\\w\\d,. ]{1,40})";
    final static String address = "([-_А-Яа-яЁё\\w\\d,. ]{1,40})";
    final static String dateTime = "\\s*\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\s*";
    final static String emailRegExp = "([-_А-Яа-яЁё\\w\\d]{1,40})@([-_А-Яа-яЁё\\w\\d]{1,20}).([-_А-Яа-яЁё\\w\\d]{1,4})";
    final static String loginRegExp = "([-_А-Яа-яЁё\\w\\d]{1,60})";
}
