package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;*/
        HttpSession session = request.getSession();
        
        if(request.getParameter("logout") == null){
            if(session.getAttribute("user") != null){
                request.setAttribute("message", "Hello, " + session.getAttribute("user"));
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
            else{
                //if session is not valid send the user to register page
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
        }
        else{
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(session.getAttribute("username")!= null){
            /*ArrayList<String> shopList = (ArrayList)session.getAttribute("list");
            String item = request.getParameter("item");
            if(item!= null){
                shopList.add(item);
            }
            else{
                
            }*/
        }
        else{
            String user = request.getParameter("name"); 
            if(user == null || user.isEmpty()){
                request.setAttribute("missingUser", true);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            else{
                session.setAttribute("username", user);
                ArrayList<String> shopList = new ArrayList<>();
                session.setAttribute("list", shopList);
                request.setAttribute("message", "Hello, " + user);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }
        
    }

}
