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

public class SampleSarvlet_csv extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

    /* (non-Java-doc)
     * @see javax.servlet.http.HttpServlet#HttpServlet()
     */
    public SampleSarvlet_csv() {
        super();
    }

    /* (non-Java-doc)
     * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        // 追加 ここから
        response.setContentType("application/octet-stream;charset=Windows-31J");
        response.setHeader("Content-Disposition","attachment; filename=m01tokuisaki_db.csv");
        PrintWriter pw = response.getWriter();

        DbAccess db = new DbAccess();

        try {
          db.ConnectOpen();
          ResultSet res = db.ExeQuery("select * from M01TOKUISAKI order by 得意先コード");

            while (res.next()){
            	String outputString =
            	res.getString(1)+ "," +
                ((res.getString(2) != null && !res.getString(2) .isEmpty())?res.getString(2):"")+ "," +
                ((res.getString(3) != null && !res.getString(3) .isEmpty())?res.getString(3):"")+ "," +
                ((res.getString(4) != null && !res.getString(4) .isEmpty())?res.getString(4):"")+ "," +
                ((res.getString(5) != null && !res.getString(5) .isEmpty())?res.getString(5):"")+ "," +
                ((res.getString(6) != null && !res.getString(6) .isEmpty())?res.getString(6):"")+ "," +
                ((res.getString(7) != null && !res.getString(7) .isEmpty())?res.getString(7):"")+ "," +
                ((res.getString(8) != null && !res.getString(8) .isEmpty())?res.getString(8):"")+ "," +
                ((res.getString(9) != null && !res.getString(9) .isEmpty())?res.getString(9):"")+ "," +
                res.getDate(10) + "," +
                res.getDate(11);

            	pw.print(outputString);
            	pw.print(System.getProperty("line.separator"));
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

        // ここまで
    }

    /* (non-Java-doc)
     * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
