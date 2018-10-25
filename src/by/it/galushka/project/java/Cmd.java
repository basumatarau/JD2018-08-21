package by.it.galushka.project.java;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface Cmd {

    Cmd execute(HttpServletRequest req, HttpServletResponse resp);
}
