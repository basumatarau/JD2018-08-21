package by.it.voinilo.project.java;

public enum Action {

    INDEX {{

        cmd =new CmdIndex();
    }},
    LOGIN {{

        cmd =new CmdLogin();
    }},
    SIGNUP {{

        cmd =new CmdSignUp();
    }}
    ,
    CREATEAD {{

        cmd =new CmdCreateAd();
    }},
    ERROR {{

        cmd =new CmdError();
    }};

    public String getJsp = "/"+this.cmd.toString().toLowerCase() +".jsp";
    public Cmd cmd =new CmdError();

}
