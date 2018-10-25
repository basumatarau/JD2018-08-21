package by.it.bindyuk.project.java;

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
    }, TICKET {
        {
            cmd = new CmdCreateTicket();
        }
//    }, REGISTRATION {
//        {
//            this.jsp = "/registration.jsp";
//        }
//    },
    }, ERROR {
        {
            cmd = new CmdError();

        }
    };

    public Cmd cmd = new CmdError();

    public String getjsp() {
        return "/" + this.cmd.toString().toLowerCase() + ".jsp";
    }
}


