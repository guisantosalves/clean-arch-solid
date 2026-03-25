# Observer

## O que é
Quando um objeto muda de estado, todos os interessados são notificados automaticamente.

## Onde aplicar no projeto
Pacote: `com.bugpet.project.observer`

Criar um sistema de agendamento veterinário — quando uma consulta é marcada, vários serviços precisam reagir: enviar email pro dono, atualizar o painel do veterinário e registrar no log.

## Como implementar

1. Criar a interface `AppointmentObserver` com o método `void onAppointmentCreated(String petName, String date)`
2. Criar os observers concretos:
   - `OwnerEmailNotifier` — notifica o dono por email
   - `VetDashboardUpdater` — atualiza o painel do veterinário
   - `AppointmentLogger` — registra no log
3. Criar a classe `AppointmentScheduler` (Subject/Publisher) que:
   - Mantém uma `List<AppointmentObserver>`
   - Tem métodos `subscribe(observer)` e `unsubscribe(observer)`
   - Tem método `scheduleAppointment(String petName, String date)` que notifica todos os observers

## Estrutura esperada

```
observer/
  ├── AppointmentObserver.java       (interface)
  ├── OwnerEmailNotifier.java        (observer concreto)
  ├── VetDashboardUpdater.java       (observer concreto)
  ├── AppointmentLogger.java         (observer concreto)
  └── AppointmentScheduler.java      (subject/publisher)
```

## O que o código precisa ter
- Interface do observer com o método de callback
- Subject que mantém a lista de observers e notifica todos quando algo acontece
- Métodos subscribe/unsubscribe pra inscrever e desinscrever
- Os observers concretos NÃO conhecem uns aos outros — só o subject

## Como testar
- Registrar observers, agendar consulta e verificar que todos foram notificados
- Desinscrever um observer e verificar que ele NÃO recebe mais notificação
- Verificar que o subject funciona sem nenhum observer registrado (lista vazia)
