package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.KhachHangDAO;
import model.KhachHang;

/**
 * Servlet implementation class ChangeImagController
 */
@WebServlet("/changeimage")
public class ChangeImagController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeImagController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String folder = getServletContext().getRealPath("avatar");
			System.out.println(folder);
			int maxFileSize = 5000*1024;
			int maxMemSize = 5000*1024;
			
			KhachHang kh = (KhachHang)request.getSession().getAttribute("vl_khachhang");
			
			String contentType = request.getContentType();
			
			if(contentType.indexOf(contentType) >= 0) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
			
				
				//Quy định dung lượng tối đa cho một file
				factory.setSizeThreshold(maxMemSize);
				
				// Tạo file
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				upload.setSizeMax(maxFileSize);
				
				try {
					List<FileItem> files = upload.parseRequest(request);
					for(FileItem f : files) {
						if(!f.isFormField()) {
							String fileName = System.currentTimeMillis()+f.getName();
							String path = folder + "\\" + fileName;
							
							// Lưu hình ảnh được upload vào ổ cứng
							File file = new File(path);
							try {
								f.write(file);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							//Cập nhật hình ảnh cho khách hàng
							kh.setHinhAnh(fileName);
							KhachHangDAO.getInstance().changeImage(kh);
							kh = KhachHangDAO.getInstance().selectById(kh.getMaKhachHang());
						}
						else {
							String name = f.getFieldName();
							String value = f.getString();
							System.out.println(name+" : "+value);
						}
						
					}

				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
