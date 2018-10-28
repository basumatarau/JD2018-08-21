package by.it.litvin.project.java;

 enum Action {

    INDEX {{
        cmd = new CmdIndex();
    }},
    LOGIN {{
        cmd = new CmdLogin();
    }},
    RESET {{
        cmd = new CmdReset();
    }},
    LOGOUT {{
        cmd = new CmdLogout();
    }},
    CREATEFORM {{
        cmd = new CmdCreateForm();
    }},
    SIGNUP {{
        cmd = new CmdSignup();
    }},
     LISTFORM {{
         cmd = new CmdListForm();
     }},
    ERROR {{
        cmd = new CmdError();
    }};

    public String getJsp() {
        return "/" + this.cmd.toString().toLowerCase() + ".jsp";
    }

    public Cmd cmd = new CmdError();
}
