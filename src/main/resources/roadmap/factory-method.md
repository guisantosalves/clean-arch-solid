# Factory Method

## O que é
Delega a criação de objetos para subclasses, desacoplando quem usa de quem cria.

## Onde aplicar no projeto
Pacote: `com.bugpet.project.factory`

Criar uma fábrica de notificações — dependendo do tipo, cria `EmailNotification`, `SmsNotification` ou `PushNotification`.

## Como implementar

1. Criar a interface `Notification` com o método `send(String message)`
2. Criar as implementações concretas:
   - `EmailNotification`
   - `SmsNotification`
   - `PushNotification`
3. Criar a classe abstrata `NotificationFactory` com o método abstrato `createNotification()`
4. Criar as fábricas concretas:
   - `EmailNotificationFactory`
   - `SmsNotificationFactory`
   - `PushNotificationFactory`
5. Cada fábrica retorna sua implementação no `createNotification()`

## Estrutura esperada

```
factory/
  ├── Notification.java                  (interface)
  ├── EmailNotification.java             (implementação)
  ├── SmsNotification.java               (implementação)
  ├── PushNotification.java              (implementação)
  ├── NotificationFactory.java           (classe abstrata)
  ├── EmailNotificationFactory.java      (fábrica concreta)
  ├── SmsNotificationFactory.java        (fábrica concreta)
  └── PushNotificationFactory.java       (fábrica concreta)
```

## O que o código precisa ter
- Interface comum (`Notification`)
- Classe abstrata com o factory method (`NotificationFactory`)
- Subclasses que sobrescrevem o factory method e retornam a implementação correta
- O cliente usa a factory sem saber qual classe concreta está sendo criada

## Como testar
- Criar cada factory e verificar que o tipo retornado é o esperado (`assertInstanceOf`)
- Chamar `send()` e verificar que cada uma executa seu comportamento
