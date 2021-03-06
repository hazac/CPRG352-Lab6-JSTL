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
        
        HttpSession session = request.getSession();
        
        String user = (String)session.getAttribute("user");
        if(user == null || user.isEmpty()){
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        else{
            String action = request.getParameter("action");
            if(action == null){
                request.setAttribute("message", "Hello, " + session.getAttribute("user"));
                if(session.getAttribute("list") != null){
                    ArrayList<String> shopList = (ArrayList<String>)session.getAttribute("list");
                    if(!shopList.isEmpty()){
                        request.setAttribute("displayList", true);
                    }                    
                }
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
            else if(action.equals("logout")){
                session.invalidate();
                    getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    return;
            }
        }         
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if(action.equals("register")){
            String user = request.getParameter("name"); 
            if(user == null || user.isEmpty()){
                request.setAttribute("missingUser", true);
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            else{
                session.setAttribute("user", user);
                ArrayList<String> shopList = new ArrayList<>();
                session.setAttribute("list", shopList);
                request.setAttribute("message", "Hello, " + user);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }
        if(action.equals("add")){
            String user = (String)session.getAttribute("user");
            ArrayList<String> shopList = (ArrayList<String>)session.getAttribute("list");
            String item = request.getParameter("item");
            if(item == null || item.equals("")){
                request.setAttribute("missingItem", true);                
            }
            else{                
                shopList.add(item);
            } 
            request.setAttribute("message", "Hello, " + user);
            session.setAttribute("list", shopList);
            request.setAttribute("displayList", true);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        if(action.equals("delete")){
            String user = (String)session.getAttribute("user");
            ArrayList<String> shopList = (ArrayList<String>)session.getAttribute("list");
            String del = request.getParameter("product");
            if(del == null || del.isEmpty()){
                request.setAttribute("selectDel", true);
                /*getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;*/
            }
            else{                
                shopList.remove(del);
            }
            request.setAttribute("message", "Hello, " + user);
            session.setAttribute("list", shopList);
            if(shopList.isEmpty()){
            request.setAttribute("displayList", false);
            }
            else{
                request.setAttribute("displayList", true);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;            
        }        
    }
}
