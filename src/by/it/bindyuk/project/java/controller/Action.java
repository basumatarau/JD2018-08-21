package by.it.bindyuk.project.java.controller;

public enum Action {

    INDEX {
        {
            cmd = new CmdIndex();
        }
    }, LOGIN {
        {
            cmd = new CmdLogin();
        }
    }, SIGNUP {
        {
            cmd = new CmdSignup();
        }
    }, ERROR {
        {
            cmd = new CmdError();
        }
    }, TICKET {
        {
            cmd = new CmdTicket();
        }
    }, HOME {
        {
            cmd = new CmdHome();
        }
    }, ORDER {
        {
            cmd = new CmdOrder();
        }
    }, PROFILE {
        {
            cmd = new CmdProfile();
        }
    }, RESET {
        {
            cmd = new CmdReset();
        }
    }, EDIT {
        {
            cmd = new CmdEdit();
        }
    };

    public Cmd cmd = new CmdError();

    public String getJsp() {
        return "/" + this.cmd.toString().toLowerCase() + ".jsp";
    }
}


