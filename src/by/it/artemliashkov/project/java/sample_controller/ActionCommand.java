package by.it.artemliashkov.project.java.sample_controller;

import javax.servlet.http.HttpServletRequest;
interface ActionCommand {
    String execute(HttpServletRequest request);
}