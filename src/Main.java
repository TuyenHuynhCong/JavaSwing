
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        show_NguoiDung();
        show_User();
        
    }
    public ArrayList<NguoiDung> NguoiDungList(){
    ArrayList<NguoiDung> NguoiDungsList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMIN\\SQLEXPRESS;databaseName=CuoiKy;user=tuyen;password=1234";
            Connection con=DriverManager.getConnection(url);
            String query1="SELECT * FROM HangHoa";
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery(query1);
            NguoiDung nguoiDung;
            while(rs.next()){
                nguoiDung=new NguoiDung(rs.getInt("ID"), rs.getInt("SoLuong"), rs.getInt("GiaNhap"), rs.getInt("GiaBan"), rs.getString("TenHang"), rs.getDate("NgayNhap"), rs.getDate("NgayHetHan"));
                NguoiDungsList.add(nguoiDung);
            }
                    
                    
            
        } catch (Exception e) {
        }
        return NguoiDungsList;
    }
    public void show_NguoiDung(){
        ArrayList<NguoiDung> list= NguoiDungList();
        DefaultTableModel model = (DefaultTableModel)table_NguoiDung.getModel();
        Object[] row =new Object[7];
        for(int i=0; i< list.size();i++)
        {
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getTenHang();
            row[2]=list.get(i).getNgayNhap();
            row[3]=list.get(i).getGiaNhap();
            row[4]=list.get(i).getGiaBan();
            row[5]=list.get(i).getSoLuong();
            row[6]=list.get(i).getNgayHetHan();
            model.addRow(row);
        }
        
    }
    public void show_NguoiDung(String sql){
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMIN\\SQLEXPRESS;databaseName=CuoiKy;user=tuyen;password=1234";
            Connection conn=DriverManager.getConnection(url);
            int number;
            Vector row,column;
            column=new Vector();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            ResultSetMetaData metagata=rs.getMetaData();
            number=metagata.getColumnCount();// tra ve so cot
             for(int i=1;i<=number;i++)
             {
                 column.add(metagata.getColumnName(i));/// laay ra tieu de cua cac cot
             }
             DefaultTableModel model=(DefaultTableModel)table_NguoiDung.getModel();
             model.setColumnIdentifiers(column);
             while(rs.next())
             {
                 row=new Vector();
                 for(int i=1;i<=number;i++)
                 {
                     row.addElement(rs.getString(i));
                 }
                 model.addRow(row); 
                 table_NguoiDung.setModel(model);
             }
                  
        } catch (Exception e) {
             System.out.println(e.toString());
        }
    }
     public ArrayList<User> UserList(){
    ArrayList<User> UsersList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMIN\\SQLEXPRESS;databaseName=CuoiKy;user=tuyen;password=1234";
            Connection con=DriverManager.getConnection(url);
            String query1="SELECT * FROM TaiKhoan";
            Statement st =con.createStatement();
            ResultSet rs =st.executeQuery(query1);
           // NguoiDung nguoiDung;
           User user;
            while(rs.next()){
                user = new User( rs.getInt("sno"),rs.getString("Username"),rs.getString("Password") );
               // NguoiDungsList.add(nguoiDung);
                UsersList.add(user);
            }
                    
                    
            
        } catch (Exception e) {
        }
        return UsersList;
    }
      public void show_User(){
        ArrayList<User> list= UserList();
        DefaultTableModel model = (DefaultTableModel)Table_User.getModel();
        Object[] row =new Object[3];
        for(int i=0; i< list.size();i++)
        {
            row[0]=list.get(i).getsno();
            row[1]=list.get(i).getUsername();
            row[2]=list.get(i).getPassword();
            
            model.addRow(row);
        }
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_NguoiDung = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        TenHang = new javax.swing.JLabel();
        NgayNhap = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtTenHang = new javax.swing.JTextField();
        txtNgayNhap = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtNgayHetHan = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_User = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnThemNhanVien = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        btnSuaNhanVien = new javax.swing.JButton();
        btnXoaNhanVien = new javax.swing.JButton();
        btnLamMoiUser = new javax.swing.JButton();
        txtSno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();
        backg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chào Mừng Bạn Đến Với Tạp Hóa Dâu Tây");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_NguoiDung.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        table_NguoiDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên Hàng", "Ngày Nhập", "Giá Nhập", "Giá Bán", "Số Lượng", "Ngày Hết Hạn"
            }
        ));
        table_NguoiDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_NguoiDungMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_NguoiDung);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 1060, 170));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("TẠP HÓA DÂU TÂY");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 72));

        ID.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ID.setText("ID");
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 93, 26, -1));

        TenHang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TenHang.setText("Tên Hàng");
        getContentPane().add(TenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 127, -1, -1));

        NgayNhap.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        NgayNhap.setText("Ngày Nhập");
        getContentPane().add(NgayNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 167, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Giá Nhập");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 202, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Giá Bán");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 239, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Số Lượng");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 277, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Ngày Hết Hạn");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 312, -1, -1));
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 90, 100, -1));
        getContentPane().add(txtTenHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 124, 100, -1));
        getContentPane().add(txtNgayNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 164, 100, -1));
        getContentPane().add(txtGiaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 208, 100, -1));
        getContentPane().add(txtGiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 236, 100, -1));
        getContentPane().add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 274, 100, -1));
        getContentPane().add(txtNgayHetHan, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 312, 100, -1));

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconAđ20.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 90, 30));

        btnSua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconSer20.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 80, 30));

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconDelete20.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 90, 30));

        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconRefesh.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        getContentPane().add(btnLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 100, 30));
        getContentPane().add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 250, 30));

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconsearch.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        getContentPane().add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 110, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        Table_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Username", "Password"
            }
        ));
        Table_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_UserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_User);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Quản Lý Nhân Viên");

        btnThemNhanVien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThemNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconAđ20.png"))); // NOI18N
        btnThemNhanVien.setText("Thêm Nhân Viên");
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Username");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Password");

        btnSuaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSuaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconSer20.png"))); // NOI18N
        btnSuaNhanVien.setText("Sửa");
        btnSuaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNhanVienActionPerformed(evt);
            }
        });

        btnXoaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconDelete20.png"))); // NOI18N
        btnXoaNhanVien.setText("Xóa");
        btnXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhanVienActionPerformed(evt);
            }
        });

        btnLamMoiUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLamMoiUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconRefesh20.png"))); // NOI18N
        btnLamMoiUser.setText("Làm Mới");
        btnLamMoiUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiUserActionPerformed(evt);
            }
        });

        txtSno.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("STT");

        btnDangXuat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconLogout.png"))); // NOI18N
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDangXuat))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThemNhanVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaNhanVien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnLamMoiUser)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                .addComponent(txtSno)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDangXuat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtSno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNhanVien)
                    .addComponent(btnSuaNhanVien)
                    .addComponent(btnXoaNhanVien)
                    .addComponent(btnLamMoiUser))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 91, -1, 250));

        backg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/blake-cheek-735144-unsplash.jpg"))); // NOI18N
        getContentPane().add(backg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void table_NguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_NguoiDungMouseClicked
        DefaultTableModel model =(DefaultTableModel)table_NguoiDung.getModel();
        int selectRowIndex = table_NguoiDung.getSelectedRow();
        txtID.setText(model.getValueAt(selectRowIndex,0).toString());
        txtTenHang.setText(model.getValueAt(selectRowIndex,1).toString());
        txtNgayNhap.setText(model.getValueAt(selectRowIndex,2).toString());
        txtGiaNhap.setText(model.getValueAt(selectRowIndex,3).toString());
        txtGiaBan.setText(model.getValueAt(selectRowIndex,4).toString());
        txtSoLuong.setText(model.getValueAt(selectRowIndex,5).toString());
        txtNgayHetHan.setText(model.getValueAt(selectRowIndex,6).toString());
    }//GEN-LAST:event_table_NguoiDungMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ADD.main(null);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtTimKiem.setText("");
        txtID.setText("");
       txtTenHang.setText("");
       txtNgayNhap.setText("");
       txtGiaNhap.setText("");
       txtGiaBan.setText("");
       txtSoLuong.setText("");
       txtNgayHetHan.setText("");
         DefaultTableModel model1 = (DefaultTableModel)table_NguoiDung.getModel();
            model1.setRowCount(0);
            show_NguoiDung();
       
       
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if(table_NguoiDung.getSelectedRow()<0)
        {   
            JOptionPane.showMessageDialog(null," Bạn chưa chọn mục để sửa!!!");
        }
        else
        {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMIN\\SQLEXPRESS;databaseName=CuoiKy;user=tuyen;password=1234";
            Connection conn=DriverManager.getConnection(url);
            PreparedStatement pst=conn.prepareStatement("Update HangHoa set TenHang=?, NgayNhap=?,GiaNhap=?,GiaBan=? , SoLuong=?,NgayHetHan=? where ID=?");
            pst.setString(7,txtID.getText());
            pst.setString(1,txtTenHang.getText());
             pst.setString(2,txtNgayNhap.getText());
              pst.setString(3,txtGiaNhap.getText());
               pst.setString(4,txtGiaBan.getText());
                pst.setString(5,txtSoLuong.getText());
                 pst.setString(6,txtNgayHetHan.getText());
                 
           
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)table_NguoiDung.getModel();
            model.setRowCount(0);
            show_NguoiDung();
            JOptionPane.showMessageDialog(this,"Sửa Thành Công");
            
        } catch (Exception e) {
            System.out.println(e.toString());// ham load table dau?
        }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (table_NguoiDung.getSelectedRow()<0) {
            JOptionPane.showMessageDialog(null,"Bạn chưa chọn mục để xóa !!!");
        } else {
        
        try {
             try {
                 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
            String url="jdbc:sqlserver://ADMIN\\SQLEXPRESS;databaseName=CuoiKy;user=tuyen;password=1234";
            Connection con=DriverManager.getConnection(url);
              PreparedStatement pst = con.prepareStatement("Delete HangHoa where ID=?");
               pst.setString(1,table_NguoiDung.getValueAt(table_NguoiDung.getSelectedRow(),0).toString());
            if (JOptionPane.showConfirmDialog(this, "ban muon xoa hang hoa  nay ?",
                "comfirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                JOptionPane.showMessageDialog(this," xoa thanh cong");
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)table_NguoiDung.getModel();
                model.setRowCount(0);
                show_NguoiDung();
            }
        } catch (SQLException e) {
            //Logger.getLogger(table_NguoiDung.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(e.toString());
        }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
//        txtID.setText("");
//              txtFullname.setText("");
//              txtClass.setSelectedItem("");
//               //cbClass.setSelectedItem("");
//               txtFullname.setText(""); 
//                txtPassword.setText("");
//                txtAddress.setText("");
        if(this.txtTimKiem.getText().length()==0)
        {
       JOptionPane.showMessageDialog(this,"Bạn Chưa Nhập Dữ Liệu Cần Tìm");
        }
        else
        {
      try {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMIN\\SQLEXPRESS;databaseName=CuoiKy;user=tuyen;password=1234";
            Connection conn=DriverManager.getConnection(url);
      
     PreparedStatement pst = conn.prepareStatement("select * from HangHoa where ID=? ");
        pst.setString(1,txtTimKiem.getText());
        String sql="select * from HangHoa where ID like N'%"+this.txtTimKiem.getText()+"%' or TenHang like N'%"+this.txtTimKiem.getText()+"%' or NgayNhap like N'%"+this.txtTimKiem.getText()+"%' or GiaNhap like N'%"+this.txtTimKiem.getText()+"%'or GiaBan like N'%"+this.txtTimKiem.getText()+"%'or SoLuong like N'%"+this.txtTimKiem.getText()+"%'or NgayHetHan like N'%"+this.txtTimKiem.getText()+"%'";

         ResultSet rs=pst.executeQuery();
         // ResultSet rs=pst.executeUpdate();
         DefaultTableModel model= (DefaultTableModel)table_NguoiDung.getModel();
             model.setRowCount(0);
             //show_NguoiDung();
             show_NguoiDung(sql);
                
            } catch (Exception e) {
                
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void Table_UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_UserMouseClicked
        DefaultTableModel model1 =(DefaultTableModel)Table_User.getModel();
        int selectRowIndex = Table_User.getSelectedRow();
          txtSno.setText(model1.getValueAt(selectRowIndex,0).toString());
        txtUser.setText(model1.getValueAt(selectRowIndex,1).toString());
        txtPass.setText(model1.getValueAt(selectRowIndex,2).toString());
        
       
    }//GEN-LAST:event_Table_UserMouseClicked

    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed
        ADDNhanVien.main(null);
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void btnSuaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNhanVienActionPerformed
        if(Table_User.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn mục để sửa!!!");
        }
        else
        {
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMIN\\SQLEXPRESS;databaseName=CuoiKy;user=tuyen;password=1234";
            Connection conn=DriverManager.getConnection(url);
            PreparedStatement pst=conn.prepareStatement("Update TaiKhoan set Username=?, Password=? where sno=?");
            pst.setString(3,txtSno.getText());
            pst.setString(1,txtUser.getText());
             pst.setString(2,txtPass.getText());
              
                 
           
            pst.executeUpdate();
            DefaultTableModel model1 = (DefaultTableModel)Table_User.getModel();
            model1.setRowCount(0);
            show_User();
            JOptionPane.showMessageDialog(this,"Sửa Thành Công");
            
        } catch (Exception e) {
            System.out.println(e.toString());// ham load table dau?
        }
        }
    }//GEN-LAST:event_btnSuaNhanVienActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnLamMoiUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiUserActionPerformed
                txtSno.setText("");
                txtUser.setText("");
                txtPass.setText("");
                //Main b=new Main();
        DefaultTableModel model1 = (DefaultTableModel)Table_User.getModel();
            model1.setRowCount(0);
            show_User();
                 
                
               
    }//GEN-LAST:event_btnLamMoiUserActionPerformed

    private void btnXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhanVienActionPerformed
        if(Table_User.getSelectedRow()<0)
        {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn mục để xóa!!!");
            }
        else
        {
        try {
             try {
                 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             }
            String url="jdbc:sqlserver://ADMIN\\SQLEXPRESS;databaseName=CuoiKy;user=tuyen;password=1234";
            Connection con=DriverManager.getConnection(url);
              PreparedStatement pst = con.prepareStatement("Delete TaiKhoan where Sno=?");
               pst.setString(1,Table_User.getValueAt(Table_User.getSelectedRow(),0).toString());
            if (JOptionPane.showConfirmDialog(this, "Bạn Muốn Xóa Tài Khoản này ?",
                "comfirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                JOptionPane.showMessageDialog(this," xóa thành công");
                pst.executeUpdate();
                DefaultTableModel model2 = (DefaultTableModel)Table_User.getModel();
                model2.setRowCount(0);
                show_User();
                txtSno.setText("");
                txtUser.setText("");
                txtPass.setText("");
            }
        } catch (SQLException e) {
            //Logger.getLogger(table_NguoiDung.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(e.toString());
        }
        }
    }//GEN-LAST:event_btnXoaNhanVienActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        LoginCheck.main(null);
        this.dispose();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JLabel NgayNhap;
    private javax.swing.JTable Table_User;
    private javax.swing.JLabel TenHang;
    private javax.swing.JLabel backg;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiUser;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaNhanVien;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemNhanVien;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_NguoiDung;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNgayHetHan;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtSno;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenHang;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
