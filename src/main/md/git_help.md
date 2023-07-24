### 本地配置Git
1. 安装 Git：首先，确保已经在您的计算机上安装了 Git。您可以从官方网站 https://git-scm.com/downloads 下载适合您操作系统的版本，并按照安装向导进行安装。

2. 配置用户名和邮箱：在命令行中输入以下命令，将您的用户名和电子邮件地址配置到 Git 中。请将 "Your Name" 替换为您的真实姓名，将 "your_email@example.com" 替换为您的电子邮件地址。

```Shell
git config --global user.name "Your Name"
git config --global user.email your_email@example.com
```

3. 配置文本编辑器：如果您想在 Git 中使用特定的文本编辑器来编写提交信息，请运行以下命令，并将 "editor name" 替换为您选择的文本编辑器的名称（例如，"vim" 或 "nano"）。
```shell
git config --global core.editor "editor name"
```

4. 查看配置信息：如果您想查看已经配置的 Git 信息，可以运行以下命令：
```Shell
git config --list
```
这将显示当前的 Git 配置信息，包括用户名、邮箱、文本编辑器等。


## 解决问题

> Git报错解决：OpenSSL SSL_read: Connection was reset, errno 10054

修改设置，解除ssl验证。

`git config --global http.sslVerify "false"`