Runner 是用来编译, 测试, 打包的服务器节点



runner
```

sudo curl --output /usr/local/bin/gitlab-runner https://gitlab-runner-downloads.s3.amazonaws.com/latest/binaries/gitlab-runner-darwin-amd64



```


[GitLab CI 使用目录](https://docs.gitlab.com/ee/ci/)

[注册runner](https://docs.gitlab.com/runner/register/index.html)




`.gitlab-ci.yml`是[YAML](https://en.wikipedia.org/wiki/YAML)文件，所以你必须特别注意缩进。总是使用空格，而不是标签。

**Note:** `.gitlab-ci.yml` is a [YAML](https://en.wikipedia.org/wiki/YAML) file so you have to pay extra attention to indentation. Always use spaces, not tabs.




[gitlab runner ](https://docs.gitlab.com/runner/)
Docker 不一定要装
```

如果您想使用Docker，请确保您的版本`v1.5.0`至少已安装。


```


[使用GitLab Runner](https://docs.gitlab.com/runner/commands/README.html)

# 官网说了现在都用 gitlab-runner
```

gitlab-runner --help


```


追加`--help`命令后，查看其特定的帮助页面：

```
gitlab-runner <command> --help

```


```
gitlab-runner register --name my-runner --url http://gitlab.example.com --registration-token my-registration-token
```


要检查所有可能的参数和环境，执行：

```

gitlab-runner register --help


```



**注意：**从GitLab Runner 10.0开始，该`exec`命令已被**弃用** ，并将在即将发布的其中一个版本中被删除。






# YAML
### before_script
### after_script
### stages
### types
### variables
### cache



## before_script
`before_script`用于定义应在所有作业（包括部署作业）之前运行的命令，但是在恢复工件之后运行。这可以是一个数组或一个多行字符串。
`before_script` is used to define the command that should be run before all jobs, including deploy jobs, but after the restoration of artifacts. This can be an array or a multi-line string.


## after_script

```

在GitLab 8.7中引入，需要Gitlab Runner v1.2

```
`after_script`用于定义将在所有作业之后运行的命令。这必须是一个数组或一个多行字符串。

`after_script` is used to define the command that will be run after for all jobs. This has to be an array or a multi-line string.

**注：** 在`before_script`与主要`script`是串联在一个上下文/容器中运行。这`after_script`是单独运行的，所以根据执行程序的不同，在工作树之外完成的更改可能不可见，例如安装的软件 `before_script`。

```

> **Note:** The `before_script` and the main `script` are concatenated and run in a single context/container. The `after_script` is run separately, so depending on the executor, changes done outside of the working tree might not be visible, e.g. software installed in the `before_script`.


```

## stages

`stages` is used to define stages that can be used by jobs. The specification of `stages` allows for having flexible multi stage pipelines.


`stages`用于定义可以被作业使用的阶段。规范`stages`允许有灵活的多级管道。

元素`stages`的排序定义了作业执行的顺序：

1.  同一阶段的工作是并行的。
2.  下一阶段的工作是在上一阶段的工作顺利完成之后运行的。

我们来看下面的例子，它定义了3个阶段：

`stages` is used to define stages that can be used by jobs. The specification of `stages` allows for having flexible multi stage pipelines.

The ordering of elements in `stages` defines the ordering of jobs' execution:

1.  Jobs of the same stage are run in parallel.
2.  Jobs of the next stage are run after the jobs from the previous stage complete successfully.

Let's consider the following example, which defines 3 stages:

```
stages:
  - build
  - test
  - deploy
```
1.  First, all jobs of `build` are executed in parallel.
2.  If all jobs of `build` succeed, the `test` jobs are executed in parallel.
3.  If all jobs of `test` succeed, the `deploy` jobs are executed in parallel.
4.  If all jobs of `deploy` succeed, the commit is marked as `passed`.
5.  If any of the previous jobs fails, the commit is marked as `failed` and no jobs of further stage are executed.

There are also two edge cases worth mentioning:

1.  If no `stages` are defined in `.gitlab-ci.yml`, then the `build`, `test` and `deploy` are allowed to be used as job's stage by default.
2.  If a job doesn't specify a `stage`, the job is assigned the `test` stage.


1.  首先，所有的工作`build`都是并行执行的。
2.  如果所有的工作都`build`成功了，那么这些`test`工作是并行执行的。
3.  如果所有的工作都`test`成功了，那么这些`deploy`工作是并行执行的。
4.  如果所有`deploy`成功的作业，提交被标记为`passed`。
5.  如果之前的任务失败，则提交被标记为，`failed`并且没有进一步阶段的任务被执行。

还有两个边缘案例值得一提：

1.  如果没有`stages`被定义`.gitlab-ci.yml`，那么`build`， `test`和`deploy`允许被用作默认作业的阶段。
2.  如果一项工作没有指定a `stage`，则该工作被分配到`test`舞台上。





## types 已近弃用,它是stages的别名

## variables

```

在GitLab Runner v0.5.0中引入。

```

GitLab CI允许您添加`.gitlab-ci.yml`在作业环境中设置的变量。这些变量存储在Git仓库中，用于存储非敏感的项目配置，例如：

```
variables:
  DATABASE_URL: "postgres://postgres@postgres/my_database"
```
**Note:** Integers (as well as strings) are legal both for variable's name and value. Floats are not legal and cannot be used.

这些变量稍后可以在所有执行的命令和脚本中使用。YAML定义的变量也被设置为所有创建的服务容器，从而允许对其进行微调。变量也可以在[作业级别](https://docs.gitlab.com/ee/ci/yaml/README.html#job-variables)上定义 。

除了用户定义的变量外，还有由Runner自己设置的变量。其中一个例子是`CI_COMMIT_REF_NAME`具有项目所在分支或标签名称的值。除了你可以设置的变量`.gitlab-ci.yml`，还有所谓的秘密变量，可以在GitLab的用户界面中设置。

[详细了解变量。](https://docs.gitlab.com/ee/ci/variables/README.html)

These variables can be later used in all executed commands and scripts. The YAML-defined variables are also set to all created service containers, thus allowing to fine tune them. Variables can be also defined on a [job level](https://docs.gitlab.com/ee/ci/yaml/README.html#job-variables).

Except for the user defined variables, there are also the ones set up by the Runner itself. One example would be `CI_COMMIT_REF_NAME` which has the value of the branch or tag name for which project is built. Apart from the variables you can set in `.gitlab-ci.yml`, there are also the so called secret variables which can be set in GitLab's UI.

[Learn more about variables.](https://docs.gitlab.com/ee/ci/variables/README.html)


##  cache



# Jobs


`.gitlab-ci.yml`允许您指定无限数量的Job。每个Job必须有一个独特的名字，这不是上面提到的关键字之一。Job由定义Job行为的参数列表定义。

```
job_name:
  script:
    - rake spec
    - coverage
  stage: test
  only:
    - master
  except:
    - develop
  tags:
    - ruby
    - postgres
  allow_failure: true
```




| Keyword | Required | Description |
| --- | --- | --- |
| script | yes | Defines a shell script which is executed by Runner |
| image | no | Use docker image, covered in [Using Docker Images](https://docs.gitlab.com/ee/ci/docker/using_docker_images.html#define-image-and-services-from-gitlab-ciyml) |
| services | no | Use docker services, covered in [Using Docker Images](https://docs.gitlab.com/ee/ci/docker/using_docker_images.html#define-image-and-services-from-gitlab-ciyml) |
| stage | no | Defines a job stage (default: `test`) |
| type | no | Alias for `stage` |
| variables | no | Define job variables on a job level |
| only | no | Defines a list of git refs for which job is created |
| except | no | Defines a list of git refs for which job is not created |
| tags | no | Defines a list of tags which are used to select Runner |
| allow_failure | no | Allow job to fail. Failed job doesn't contribute to commit status |
| when | no | Define when to run job. Can be `on_success`, `on_failure`, `always` or `manual` |
| dependencies | no | Define other jobs that a job depends on so that you can pass artifacts between them |
| artifacts | no | Define list of [job artifacts](https://docs.gitlab.com/ee/user/project/pipelines/job_artifacts.html) |
| cache | no | Define list of files that should be cached between subsequent runs |
| before_script | no | Override a set of commands that are executed before job |
| after_script | no | Override a set of commands that are executed after job |
| environment | no | Defines a name of environment to which deployment is done by this job |
| coverage | no | Define code coverage settings for a given job |
| retry | no | Define how many times a job can be auto-retried in case of a failure |


| 关键词 | 需要 | 描述 |
| --- | --- | --- |
| 脚本 | 是 | 定义由Runner执行的shell脚本 |
| 镜像 | 没有 | 使用[Docker](https://docs.gitlab.com/ee/ci/docker/using_docker_images.html#define-image-and-services-from-gitlab-ciyml)镜像，请参阅[使用Docker镜像](https://docs.gitlab.com/ee/ci/docker/using_docker_images.html#define-image-and-services-from-gitlab-ciyml) |
| 服务 | 没有 | 使用[Docker](https://docs.gitlab.com/ee/ci/docker/using_docker_images.html#define-image-and-services-from-gitlab-ciyml)服务，请参阅[使用Docker镜像](https://docs.gitlab.com/ee/ci/docker/using_docker_images.html#define-image-and-services-from-gitlab-ciyml) |
| 阶段 | 没有 | 定义一个工作阶段（默认：`test`） |
| 类型 | 没有 | 别名 `stage` |
| 变量 | 没有 | 在作业级别定义作业变量 |
| 只要 | 没有 | 定义创建作业的git refs列表 |
| 除 | 没有 | 定义一个没有创建任务的git refs列表 |
| 标签 | 没有 | 定义用于选择Runner的标签列表 |
| allow_failure | 没有 | 让作业失败。失败的作业不参与提交状态 |
| 什么时候 | 没有 | 定义何时运行作业。可以是`on_success`，`on_failure`，`always`或者`manual` |
| 依赖 | 没有 | 定义作业所依赖的其他作业，以便可以在它们之间传递工件 |
| 文物 | 没有 | 定义[作业工件的](https://docs.gitlab.com/ee/user/project/pipelines/job_artifacts.html)列表[](https://docs.gitlab.com/ee/user/project/pipelines/job_artifacts.html) |
| 高速缓存 | 没有 | 定义应在后续运行之间进行缓存的文件列表 |
| before_script | 没有 | 覆盖在作业之前执行的一组命令 |
| after_script | 没有 | 覆盖作业后执行的一组命令 |
| 环境 | 没有 | 定义由此作业进行部署的环境的名称 |
| 覆盖 | 没有 | 定义给定作业的代码覆盖率设置 |
| 重试 | 没有 | 定义在发生故障的情况下可以自动重试的次数 |


## script

`script`是一个由Runner执行的shell脚本。例如：

```
job:
  script: "bundle exec rspec"

```

这个参数也可以包含几个使用数组的命令：

```
job:
  script:
    - uname -a
    - bundle exec rspec

```

有时，`script`命令将需要用单引号或双引号括起来。例如，包含冒号（`:`）的命令需要用引号括起来，以便YAML解析器知道将整个事物解释为字符串而不是“key：value”对。使用特殊字符时要小心： `:`，`{`，`}`，`[`，`]`，`,`，`&`，`*`，`#`，`?`，`|`，`-`，`<`，`>`，`=`，`!`，`%`，`@`，```。




