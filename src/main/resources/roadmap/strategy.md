# Strategy

## O que é
Permite trocar o algoritmo inteiro em tempo de execução via composição.

## Onde aplicar no projeto
Pacote: `com.bugpet.project.strategy`

Criar um sistema de cálculo de desconto para serviços veterinários — dependendo do plano do pet (básico, premium, VIP), o desconto muda.

## Como implementar

1. Criar a interface `DiscountStrategy` com o método `BigDecimal applyDiscount(BigDecimal price)`
2. Criar as implementações:
   - `BasicDiscount` — sem desconto (retorna o preço original)
   - `PremiumDiscount` — 10% de desconto
   - `VipDiscount` — 20% de desconto
3. Criar a classe `PetServiceCheckout` (Context) que:
   - Recebe uma `DiscountStrategy` no construtor ou via setter
   - Tem um método `calculateFinalPrice(BigDecimal price)` que delega pra strategy

## Estrutura esperada

```
strategy/
  ├── DiscountStrategy.java        (interface)
  ├── BasicDiscount.java           (implementação)
  ├── PremiumDiscount.java         (implementação)
  ├── VipDiscount.java             (implementação)
  └── PetServiceCheckout.java      (context)
```

## O que o código precisa ter
- Interface funcional (`@FunctionalInterface`) com um único método
- Implementações concretas de cada estratégia
- Context que recebe a strategy e delega o cálculo
- O Context nunca sabe qual implementação concreta está usando

## Como testar
- Criar o checkout com cada strategy e verificar o valor final
- Trocar a strategy em runtime e verificar que o resultado muda
- Testar com lambda (já que a interface é funcional)
