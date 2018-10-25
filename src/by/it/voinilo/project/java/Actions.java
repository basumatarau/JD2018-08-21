package by.it.voinilo.project.java;

public enum Actions {

    INDEX{{
        this.jsp="/index.jsp";
    }},SIGNUP
            {{this.jsp="/index.jsp";
            }},LOGIN{{this.jsp="/index.jsp";
    }},LOGOUT{{this.jsp="/index.jsp";}};

    public String jsp= "/error.jsp";
}
