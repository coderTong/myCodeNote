# AWSIoTDataTests===========================

操作
Get
Update
Delete
Publish


InvalidData
ValidData
NotPresent 
Present




##  更新  Thing  InvalidData (无效数据?)
-UpdateThingInvalidData
AWSIoTDataUpdateThingShadowRequest


## 更新 Update Thing ValidData(有效数据)
AWSIoTDataUpdateThingShadowRequest

## GetThing Not Present
AWSIoTDataGetThingShadowRequest


## Get Thing Present

AWSIoTDataUpdateThingShadowRequest


## Delete Thing NotPresent

AWSIoTDataDeleteThingShadowRequest


## Delete Thing Presen
AWSIoTDataUpdateThingShadowRequest


## Publish
AWSIoTDataPublishRequest



## WebsocketConnectStateTransition
AWSIoTMQTTStatus
AWSServiceConfiguration
AWSIoTMQTTLastWillAndTestament
AWSIoTMQTTConfiguration
AWSIoTDataManager


##  WebSocket MQTT PubSub ----发布提交
AWSServiceConfiguration
AWSIoTMQTTLastWillAndTestament
AWSIoTMQTTConfiguration



## Reconnect Progression 重新连接
AWSServiceConfiguration
AWSIoTMQTTLastWillAndTestament
AWSIoTMQTTConfiguration
AWSIoTMQTTConfiguration
AWSIoTDataManager


## WebSocket Shadow Operations(Shadow 操作?)

类
```

AWSTestUtility

AWSIoTData


AWSIoTDataDeleteThingShadowRequest

AWSIoTDataUpdateThingShadowRequest


AWSIoTDataPublishRequest


AWSIoTMQTTStatus


AWSServiceConfiguration

AWSIoTMQTTLastWillAndTestament

AWSIoTDataManager


AWSIoTMQTTConfiguration

AWSIoTAttachPrincipalPolicyRequest

AWSIoTAttachThingPrincipalRequest
```

有一个生成随机字符串


# AWSIoTTests==========================

## 构造器
testConstructors

## 描述证书
testDescribeCertificate

## 创建Policy
testCreatePolicy

## 附件 Policy
AWSIoTAttachPrincipalPolicyRequest


# testAttachThingPrincipal

AWSIoTAttachThingPrincipalRequest


## 不要证书传输?
testCancelCertificateTransfer
AWSIoTCancelCertificateTransferRequest


## 创建Policy 版本?

AWSIoTCreatePolicyVersionRequest

## 创建thing
AWSIoTCreateThingRequest


## 创建TopicRule
AWSIoTCreateTopicRuleRequest

## 创建证书
AWSIoTDeleteCertificateRequest


## 删除Policy
AWSIoTDeletePolicyRequest


## 删除PolicyVersion
AWSIoTDeletePolicyVersionRequest

## 删除thing
AWSIoTDeleteThingRequest


## 删除TopicRule

AWSIoTDeleteTopicRuleRequest

## 描述thing
AWSIoTDescribeThingRequest

## 拆? Detach PrincipalPolicy
AWSIoTDetachPrincipalPolicyRequest


##  Detach ThingPrincipal
AWSIoTDetachThingPrincipalRequest


## Get Policy
AWSIoTGetPolicyRequest



## Get Policy Version
AWSIoTGetPolicyVersionRequest



## GetTopicRule
AWSIoTGetTopicRuleRequest



## List Certificates (列出证书列表)
AWSIoTListCertificatesRequest


## List Policies

AWSIoTListPoliciesRequest


## 列出所有版本 ListPolicyVersions
AWSIoTListPolicyVersionsRequest


##  List PrincipalPoliciesRequest

AWSIoTListPrincipalPoliciesRequest


## List Principal Things

AWSIoTListPrincipalThingsRequest

## List Thing Principals

AWSIoTListThingPrincipalsRequest



## ListThings

AWSIoTListThingsRequest


## ListTopicRules
AWSIoTListTopicRulesRequest



## 拒绝证书转换? RejectCertificateTransfer
AWSIoTRejectCertificateTransferRequest
```
拒绝挂起的证书传输。物联网在AWS拒绝证书转让，证书状态的变化从pending_transfer无效。

检查挂起的证书转让，叫listcertificates列举你的证书。

此操作只能由传输目的地调用。调用后，证书将返回到源代码帐户中的非活动状态。


Rejects a pending certificate transfer. After AWS IoT rejects a certificate transfer, the certificate status changes from PENDING_TRANSFER to INACTIVE.

To check for pending certificate transfers, call ListCertificates to enumerate your certificates.

This operation can only be called by the transfer destination. After it is called, the certificate will be returned to the source's account in the INACTIVE state.

```


## 更换TopicRule  ReplaceTopicRule

AWSIoTReplaceTopicRuleRequest

```

替换指定的规则。必须为新规则指定所有参数。创建规则是管理员级别的操作。任何拥有创建规则权限的用户都能够访问规则所处理的数据。

Replaces the specified rule. You must specify all parameters for the new rule. Creating rules is an administrator-level action. Any user who has permission to create rules will be able to access data processed by the rule.


```



## SetDefaultPolicyVersion

AWSIoTSetDefaultPolicyVersionRequest


## 转换,替换? TransferCertificate
AWSIoTTransferCertificateRequest

## 更新UpdateCertificate

AWSIoTUpdateCertificateRequest


## UpdateThing

AWSIoTUpdateThingRequest
