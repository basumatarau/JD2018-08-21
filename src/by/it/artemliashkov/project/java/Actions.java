package by.it.artemliashkov.project.java;
import by.it.artemliashkov.project.java.cmd.*;

public enum Actions {
    INDEX {{
        cmd = new CmdIndex();
    }},
    LOGIN {{
        cmd = new CmdLogin();
    }},
    RESET {{
        cmd = new CmdReset();
    }},
    SIGNUP {{
        cmd = new CmdSignUp();
    }},
    CREATECOMPANY {{
        cmd = new CmdCreateCompany();
    }},

    ERROR {{
        cmd = new CmdError();
    }};

    public String getJsp() {
        return "/" + this.cmd.toString().toLowerCase() + ".jsp";
    }

    public Cmd cmd = new CmdError();

}