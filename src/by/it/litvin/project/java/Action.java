package by.it.litvin.project.java;

public enum Action {

    INDEX{{
        cmd=new CmdIndex();
    }},LOGIN{{
        cmd = new CmdLogin();
    }},LOGOUT{{
            cmd=new CmdLogout();
    }},CREATEFORM{{
        cmd=new CmdCreateForm();
    }},SIGNUP{{
        cmd=new CmdSignup();
    }},ERROR{{
        cmd= new CmdError();
    }};

    public String getJsp(){
        return "/"+this.cmd.toString().toLowerCase()+".jsp";
    }
    public Cmd cmd=new CmdError();
}
