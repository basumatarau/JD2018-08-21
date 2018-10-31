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
    }},
    RESET {{cmd= new CmdReset();}};

    public String getJsp(){ return "/"+this.cmd.toString().toLowerCase() +".jsp";}
    public Cmd cmd =new CmdError();

}
