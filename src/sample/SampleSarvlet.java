package sample;

import java.io.IOException;
// 追加 ここから
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// ここまで


/**
 * Servlet implementation class for Servlet: GoodsDisplayServlet2
 *
 */

public class SampleSarvlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

    /* (non-Java-doc)
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public SampleSarvlet () {
        super();
    }

    /* (non-Java-doc)
     * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // 追加 ここから
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<head><title>Oracle11gXE_JavaServlet TEST</title></head>");
        pw.println("<HTML><BODY>"
        		+ "●Oracle11gXE接続テスト(JavaServlet)<TABLE border=1>");


        DbAccess db = new DbAccess();

        try {
          db.ConnectOpen();
          ResultSet res = db.ExeQuery("select * from M01TOKUISAKI order by 得意先コード");

            while (res.next()){
                pw.println("<TR>");
                pw.println("<TD>" + res.getString(1)+ "</TD>");
                pw.println("<TD>" + ((res.getString(2) != null && !res.getString(2) .isEmpty())?res.getString(2):"&nbsp;")+ "</TD>");
                pw.println("<TD>" + ((res.getString(3) != null && !res.getString(3) .isEmpty())?res.getString(3):"&nbsp;")+ "</TD>");
                pw.println("<TD>" + ((res.getString(4) != null && !res.getString(4) .isEmpty())?res.getString(4):"&nbsp;")+ "</TD>");
                pw.println("<TD>" + ((res.getString(5) != null && !res.getString(5) .isEmpty())?res.getString(5):"&nbsp;")+ "</TD>");
                pw.println("<TD>" + ((res.getString(6) != null && !res.getString(6) .isEmpty())?res.getString(6):"&nbsp;")+ "</TD>");
                pw.println("<TD>" + ((res.getString(7) != null && !res.getString(7) .isEmpty())?res.getString(7):"&nbsp;")+ "</TD>");
                pw.println("<TD>" + ((res.getString(8) != null && !res.getString(8) .isEmpty())?res.getString(8):"&nbsp;")+ "</TD>");
                pw.println("<TD>" + ((res.getString(9) != null && !res.getString(9) .isEmpty())?res.getString(9):"&nbsp;")+ "</TD>");
                pw.println("<TD>" + res.getDate(10)+ "</TD>");
                pw.println("<TD>" + res.getDate(11)+ "</TD>");
                pw.println("</TR>");
            }

        } catch (Exception e) {
            e.printStackTrace();

      } finally {
            try {
              db.ConnectClose();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }


        pw.println("</TABLE>");
        pw.println("<a href='./SampleSarvlet_csv' target='_blank'>DATA DOWNLOAD</a>");
        pw.println("</BODY>");
        pw.println("</HTML>");
        // ここまで
    }

    /* (non-Java-doc)
     * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}


