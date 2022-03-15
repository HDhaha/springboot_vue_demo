<template>
  <div style="padding: 10px">
    <!--功能区域-->
    <div>
      <el-button style="margin: 10px 5px" type="primary" @click="addUser">新增</el-button>
      <el-button style="margin: 10px 5px" type="primary">导入</el-button>
      <el-button style="margin: 10px 5px" type="primary">导出</el-button>
    </div>
    <!--搜索区域-->
    <div style="margin: 5px">
      <el-input v-model="search" placeholder="请输入关键字" style="width: 20%" clearable/>
      <el-button style="margin-left: 5px;" type="primary" @click="load">查询</el-button>
    </div>
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="id" label="id" width="180" v-if="ifShowId=false"/>
      <el-table-column prop="username" label="用户名" width="180" />
      <el-table-column prop="nickName" label="昵称" width="180" />
      <el-table-column prop="sex" label="性别" width="50" />
      <el-table-column prop="age" label="年龄" />
      <el-table-column prop="address" label="地址" />
      <el-table-column prop="register" label="注册日期" sortable width="180" />
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确认删除吗?" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button size="small" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div class="demo-pagination-block" style="margin-left: 270px">
      <el-pagination
          v-model:currentPage="currentPage"
          v-model:page-size="pageSize"
          :page-sizes="[5, 10, 20]"
          :small="small"
          :disabled="disabled"
          :background="background"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
<!--添加用户时,弹窗-->
      <el-dialog v-model="dialogVisible" title="提示" width="30%">
        <el-form :model="form" label-width="120px">

          <el-form-item label="用户名">
            <el-input v-model="form.username"></el-input>
          </el-form-item>
          <el-form-item label="昵称">
            <el-input v-model="form.nickName"></el-input>
          </el-form-item>
          <el-form-item label="性别">
              <el-radio label="男" v-model="form.sex">男</el-radio>
              <el-radio label="女" v-model="form.sex">女</el-radio>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="form.age"></el-input>
          </el-form-item>
          <el-form-item label="地址">
            <el-input type="textarea" v-model="form.address"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">取消</el-button>
            <el-button type="primary" @click="saveUser">确定</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: 'Home',
  components: {

  },
  data(){
    return{
      form: {},
      sex:'男',
      dialogVisible:false,
      search:'',
      currentPage:1,
      pageSize:5,
      total:10,
      tableData:[

      ]
    }
  },
  /*页面加载时调用*/
  created() {
    this.load()
  },
  methods:{
    load(){
      request.get("/api/user/findPage",{
        params:{
          pageNum:this.currentPage,
          pageSize:this.pageSize,
          search:this.search
        }
      }).then(res =>{
        console.log(res)
        this.tableData=res.data.records
        this.total=res.data.total
      })
    },
    addUser(){
      this.dialogVisible = true
      this.form={}
    },
    saveUser(){
      /*如果输入框有  值得情况下是新增*/
      if(this.form.id){
        request.put("/api/user/updateUser",this.form).then(res =>{
          console.log(res)
          if(res.code==='200'){
            this.$message({
              type:"success",
              message:"更新成功"
            })
          }else{
            this.$message({
              type:"error",
              message:res.msg
            })
          }
        })
      }else{
        request.post("/api/user/saveUser",this.form).then(res =>{
          console.log(res)
          if(res.code==='200'){
            this.$message({
              type:"success",
              message:"插入成功"
            })
          }else{
            this.$message({
              type:"error",
              message:res.msg
            })
          }
        })
      }
      this.dialogVisible=false
      this.load()
    },
    handleEdit(row){
      this.form=JSON.parse(JSON.stringify(row))
      this.dialogVisible=true
    },
    handleDelete(id){
      request.delete("/api/user/deleteUser?id="+id).then(res =>{
        console.log(id)
        if(res.code==='200'){
          this.$message({
            type:"success",
            message:"删除成功"
          })
        }else{
          this.$message({
            type:"error",
            message:res.msg
          })
        }
      })
      this.load()
    },
    handleSizeChange(pageSize){//改变当前页的条数触发
      this.pageSize=pageSize
      this.load()
    },
    handleCurrentChange(pageNum){//改变当前码触发
      this.currentPage=pageNum
      this.load()
    },
  }
}
</script>