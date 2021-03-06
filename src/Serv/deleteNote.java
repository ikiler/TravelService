package Serv;

import Util.HttpConfig;
import DB.DbManager;
import Model.Code;
import Util.GsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ikiler on 2019/2/23.
 * Email : ikiler@126.com
 */
@WebServlet("/deleteNote")
public class deleteNote extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Code code;
        int flage = DbManager.deleteNote(id);
        if (flage>0) {
            code = new Code(HttpConfig.REQUEST_SUCCESS, "Delete successful", "");
        } else if (flage == 0){
            code = new Code(HttpConfig.PARMATER_ERR, "Delete Failed not found this note", "");
        }else {
            code = new Code(HttpConfig.SERVER_ERR, "server err", "");
        }
        response.getWriter().append(GsonUtil.GsonString(code));
    }
}
