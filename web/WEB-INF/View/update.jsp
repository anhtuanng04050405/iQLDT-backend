<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="BEAN.Post, java.util.List" %>
<%
    List<Post> listPost = (List<Post>) request.getAttribute("listPost");
    Post postEdit = (Post) request.getAttribute("postEdit");
    boolean isEdit = (postEdit != null);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>QUẢN LÝ BÀI VIẾT iQLDT</title>
    <!-- CSS Bootstrap 5 & FontAwesome Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <style>
        body { background-color: #f8f9fa; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .header-title { color: #dc3545; font-weight: bold; }
        .table-dark-header th { background-color: #1a1a1a !important; color: white !important; }
        .img-thumb { width: 60px; height: 45px; object-fit: cover; border-radius: 4px; }
        .time-start { color: #198754; font-size: 0.85rem; }
        .time-end { color: #dc3545; font-size: 0.85rem; }
        .location-text { color: #b02a37; font-size: 0.9rem; font-weight: 500; }
        .action-btn { width: 32px; height: 32px; padding: 0; display: inline-flex; align-items: center; justify-content: center; }
    </style>
</head>
<body>

<div class="container-fluid py-4 px-5">
    <!-- Header Page -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h3 class="header-title m-0"><i class="fa-regular fa-newspaper me-2"></i>QUẢN LÝ BÀI VIẾT iQLDT</h3>
        
        <button class="btn btn-primary fw-bold" data-bs-toggle="modal" data-bs-target="#postModal" onclick="clearForm()">
            <i class="fa-solid fa-plus me-1"></i> Thêm bài viết mới
        </button>
        
    </div>

    <!-- Table Main -->
    <div class="card shadow-sm border-0">
        <div class="card-body p-0">
            <table class="table table-hover align-middle m-0">
                <thead class="table-dark-header text-center">
                    <tr>
                        <th style="width: 50px;">STT</th>
                        <th style="width: 80px;">Hình ảnh</th>
                        <th>Tiêu đề</th>
                        <th style="width: 200px;">Thời gian</th>
                        <th style="width: 150px;">Địa điểm</th>
                        <th>Nội dung</th>
                        <th style="width: 100px;">Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    if (listPost != null && !listPost.isEmpty()) {
                        int stt = 1;
                        for (Post p : listPost) { 
                    %>
                    <tr>
                        <td class="text-center fw-bold"><%= stt++ %></td>
                        <td class="text-center">
                            <img src="<%= p.getImgURL() != null && !p.getImgURL().isEmpty() ? p.getImgURL() : "https://xdcs.cdnchinhphu.vn/446259493575335936/2025/8/22/bk-1755856140169844190839.jpg" %>" class="img-thumb" alt="thumb">
                        </td>
                        <td class="fw-semibold text-primary"><%= p.getTieude() %></td>
                        <td>
                            <div class="time-start"><i class="fa-regular fa-calendar-check me-1"></i><%= p.getGiobatdau() + " " + p.getBatdau() %></div>
                            <div class="time-end"><i class="fa-regular fa-calendar-xmark me-1"></i><%= p.getGioketthuc() + " " + p.getKetthuc() %></div>
                        </td>
                        <td class="location-text">
                            <i class="fa-solid fa-location-dot me-1"></i><%= p.getDiadiem() %>
                        </td>
                        <td class="text-muted text-truncate" style="max-width: 250px;"><%= p.getNoidung() %></td>
                        <td class="text-center">
                            
                            <!-- Edit Button -->
                            
                            <a href="UpdateForwardController?id=<%= p.getId() %>" class="btn btn-outline-warning action-btn me-1">
                                <i class="fa-solid fa-pen"></i>
                            </a>
                                
                            <!-- Delete Button -->
                            
                            <form action="<%= request.getContextPath() %>/AdminPostServlet" method="post" class="d-inline" onsubmit="return confirm('Xóa bài viết này?');">
                                <input type="hidden" name="action" value="delete" />
                                <input type="hidden" name="id" value="<%= p.getId() %>" />
                                <button type="submit" class="btn btn-outline-danger action-btn">
                                    <i class="fa-solid fa-trash"></i>
                                </button>
                            </form>
                        </td>
                    </tr>
                    <% 
                        }
                    }
                    else { 
                    %>
                    <tr>
                        <td colspan="7" class="text-center py-4 text-muted">Chưa có bài viết nào trong CSDL!</td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Modal add/edit post -->
<div class="modal fade" id="postModal" tabindex="-1" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <form action="<%= request.getContextPath() %>/AdminPostServlet" method="post">
          <div class="modal-header">
            <h5 class="modal-title fw-bold" id="modalTitle"><%= isEdit ? "CẬP NHẬT BÀI VIẾT" : "THÊM BÀI VIẾT MỚI" %></h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
                <input type="hidden" name="action" value="<%= isEdit ? "update" : "add" %>" />
                <input type="hidden" name="id" value="<%= isEdit ? postEdit.getId() : "0" %>" />

                <div class="mb-3">
                    <label class="form-label fw-bold">Tiêu đề</label>
                    <input type="text" class="form-control" name="tieude" value="<%= isEdit && postEdit.getTieude() != null ? postEdit.getTieude() : "" %>" required>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label fw-bold">Giờ bắt đầu</label>
                        <input type="text" class="form-control" name="giobatdau" value="<%= isEdit && postEdit.getGiobatdau() != null ? postEdit.getGiobatdau() : "" %>" placeholder="HH:MM:SS">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label fw-bold">Ngày bắt đầu</label>
                        <input type="text" class="form-control" name="batdau" value="<%= isEdit && postEdit.getBatdau() != null ? postEdit.getBatdau() : "" %>" placeholder="YYYY-MM-DD">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label fw-bold">Giờ kết thúc</label>
                        <input type="text" class="form-control" name="gioketthuc" value="<%= isEdit && postEdit.getGioketthuc()!= null ? postEdit.getGioketthuc(): "" %>" placeholder="HH:MM:SS">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label fw-bold">Ngày kết thúc</label>
                        <input type="text" class="form-control" name="ketthuc" value="<%= isEdit && postEdit.getKetthuc() != null ? postEdit.getKetthuc() : "" %>" placeholder="YYYY-MM-DD">
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Địa điểm</label>
                    <input type="text" class="form-control" name="diadiem" value="<%= isEdit && postEdit.getDiadiem() != null ? postEdit.getDiadiem() : "" %>">
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">URL Hình ảnh</label>
                    <input type="text" class="form-control" name="imgURL" value="<%= isEdit && postEdit.getImgURL() != null ? postEdit.getImgURL() : "https://xdcs.cdnchinhphu.vn/446259493575335936/2025/8/22/bk-1755856140169844190839.jpg" %>">
                </div>
                <div class="mb-3">
                    <label class="form-label fw-bold">Nội dung (Markdown)</label>
                    <textarea class="form-control" name="noidung" rows="5"><%= isEdit && postEdit.getNoidung() != null ? postEdit.getNoidung() : "" %></textarea>
                </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
            <button type="submit" class="btn btn-primary"><%= isEdit ? "Cập nhật" : "Lưu bài viết" %></button>
          </div>
      </form>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<% if (isEdit) { %>
<script>
    // Automatically enable the Modal Form when you click the Edit button on a post
    var postModal = new bootstrap.Modal(document.getElementById('postModal'));
    postModal.show();
</script>
<% } %>
</body>
</html>
