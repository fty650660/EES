function AdminLoginCheck() {
    var loginName = document.getElementById("LoginName");
    var userPassword = document.getElementById("UserPassword");

    if (loginName.value == "") {
        alert("请输入登录名！");
        loginName.focus();
        return false;
    }
    if (userPassword.value == "") {
        alert("请输入登录密码！");
        userPassword.focus();
        return false;
    }
    return true;
}


function openEdit(obj, width, height) {
    var p = {
        url: obj.href,
        title: obj.innerHTML,
        width: $(this).attr("w") || width,   //456为编辑框的宽度，600为添加框的宽度,
        height: $(this).attr("h") || height, //130为编辑框的高度, 140为添加框的高度
        isResize: true
    };
    $.ligerDialog.open(p);
    return false;
}
// alert(location.href);

function closeEdit() {
    //$.ligerDialog.close(); //关闭弹出的编辑窗口
    location.href = location.href; //设置当前浏览器窗口的URL为之前的URL
    //location.href中既有目标网页，同时也包含参数及参数的值
    //刷新当前页面，刷新后的页码和页码大小值不变
}

function closeAdd() {
    // $.ligerDialog.close(); //关闭弹出的编辑窗口
    // location.href = "/Admin/MessageTypeList.aspx?page=1";           
    location.href = location.pathname + $.query.set("page", 1);
    //location.pathname只包含目标网页的路径，如"/Admin/MessageTypeList.aspx"，不包含参数和参数值
    //$.query.set(key,value)方法会自动保留之前的所有url中的参数以及参数值，然后再修改指定的page参数值
}

function deleteData(id) {
    if (confirm("确认删除吗？")) {
        // location.href = "MessageTypeList.aspx?key=<%=Request["key"] %>&page=<%=Request["page"] %>&pageSize=<%=Request["pageSize"] %>&id="+id; 
        location.href = location.pathname + $.query.set("id", id);
    }
}

function slideToggle() {
    $("#search").slideToggle();
}

function setPageSize(pageSize) {
    location.href = location.pathname + $.query.set("pageSize", pageSize);
}

function isShowSearch() {
    if ($("#tbKey").val() != "") {
        $("#search").show();
    }
}

function IsSelecteAll(obj) { //obj表示表头中的CheckBox
    var ckbArray = $("input[name='DelBox']");  //获得名称name为DelBox的一组input控件
    for (var i = 0; i < ckbArray.length; i++) { //让数据行中的CheckBox选中状态和obj的选中状态一致
        ckbArray[i].checked = obj.checked;
    }
    SetRowBackGroudColor();
}

function SetRowBackGroudColor() {
    $("tbody > tr").removeClass("tr"); //删除tbody中的tr行的样式class="tr"，所有行将受影响
    $("tbody > tr:has(:checked)").addClass("tr"); //把tbody中的tr行加上一个样式：class="tr"，被选中的所有行将受影响
}

function DeleteSelected(tableName) {
    var ckbArray = $("input[name='DelBox']:checked");  //获得名称name为DelBox的且被选中的一组input控件
    if (ckbArray.length == 0) {
        alert("请选择要删除的数据行！");
        return false;
    }
    if (!confirm("确认删除吗？")) {
        return false;
    }
    var ids = "";
    for (var i = 0; i < ckbArray.length; i++) { //让数据行中的CheckBox选中状态和obj的选中状态一致
        ids = ids + ckbArray[i].value + ",";
    }
    location.href = "DelAll.ashx?t=" + tableName + "&ids=" + ids;
}