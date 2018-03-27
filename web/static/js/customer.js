/**
 * Created by yupanpan on 2018/2/27.
 */

/*获取年份*/
function makeYear() {

    //获取年份对象
    var year = document.getElementById("year");
    //要想下拉框有更多的数据，就需要有更多的option控件
    //js获取得到年份是getFullYear()，单单的getYear()只是获取两位数
    for (var i = 1900; i <= new Date().getFullYear(); i++) {
        //生成Option控件
        var option = document.createElement("option");
        //设置option标签的value值和内容是相等的
        option.value = i;
        option.innerText = i;

        //最后将option控件绑定到select标签上
        year.appendChild(option);
    }
}

/*获取月份*/
function makeMonth() {

    var month = document.getElementById("month");
    for (var j = 1; j <= 12; j++) {
        var option = document.createElement("option");
        if (j < 10) {
            option.value = '0' + j;
            option.innerText = '0' + j;
        } else {
            option.value = j;
            option.innerText = j;
        }
        month.appendChild(option);
    }
}

/*获取日*/
function makeDay() {
    var day = document.getElementById("day");
    var month = document.getElementById("month").value;
    var end = null;

    if (month == 02) {
        end = 28;
    } else if (month == 01 || month == 03 || month == 05 || month == 07
        || month == 08 || month == 10 || month == 12) {
        end = 31;
    } else {
        end = 30;
    }
    for (var m = 1; m <= end; m++) {
        var option = document.createElement("option");
        if (m < 10) {
            option.value = '0' + m;
            option.innerText = '0' + m;
        } else {
            option.value = m;
            option.innerText = m;
        }
        day.appendChild(option);
    }
}

/*页面加载初始化数据*/
function pageInit() {
    makeYear();
    makeMonth();
    makeDay();
}


/*拼凑生日日期*/
function makeBirthday() {

    //获取年份
    var year = document.getElementById("year");
    //获取月份
    var month = document.getElementById("month");
    //获取日
    var day = document.getElementById("day");

    //拼凑
    var birthday = year + "-" + month + "-" + day;
    //创建input标签隐藏域，把生日日期放到里面
    var input = document.createElement("input");
    input.type = "hidden";
    input.value = birthday;
    input.name = "birthday"
    //将input标签绑定到form表单上
    document.getElementById("form").appendChild(input);
}

/*拼凑爱好*/
function makePreference() {

    var hobbies = document.getElementsByName("preference1")
    var preference = "";

    //遍历客户选择的爱好控件，看看是选中了哪些
    for (var i = 0; i < hobbies.length; i++) {

        //判断是否选中
        if (hobbies[i].checked) {
            preference += hobbies[i].value + ",";
        }
    }
    //注意要把最后拼凑的逗号去除
    preference = preference.substr(0, preference.length - 1);
    //创建input隐藏域标签，然后把爱好放到里面
    var input = document.createElement("input");
    input.type = "hidden";
    input.value = preference;
    input.name = "preference";
    //将input绑定到form中
    document.getElementById("form").appendChild(input);
}

/*初始化拼凑日期、爱好的函数,在表单提交的时候初始化*/
function makeForm() {
    makeBirthday();
    makePreference();
    return true;
}

