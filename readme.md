# Assignment 6: Visitor Pattern
**Author:** Madi Shalabay
**Group:** SE-2510
**Domain:** Aura Coffee (Menu Nutritional & Tax Reporting)

## Clean code principles

### 1. Meaningful names distinguishing Element vs. Visitor responsibilities
**Before:** `interface Item` and `interface Processor` with generic `process()` methods.
**After:** `MenuItem` (with `BeverageItem`, `PastryItem`) and `MenuVisitor` (with `CalorieCounterVisitor`, `TaxCalculatorVisitor`).
**Justification:** Names clearly separate the stable data structure (menu items) from external algorithms operating on them (visitors).

### 2. No instanceof or type-checking chains
**Before:** `if (item instanceof BeverageItem) { ... } else if (item instanceof PastryItem) { ... }`
**After:** `item.accept(visitor);` which triggers `visitor.visitBeverage(this);`
**Justification:** Double dispatch routes the call to the exact method at runtime without unsafe type casting or `instanceof` checks.

### 3. Single Responsibility Principle
**Before:** Putting price data, calorie math, and tax rules all inside `BeverageItem` and `PastryItem`.
**After:** Isolating calorie calculation in `CalorieCounterVisitor` and tax calculation in `TaxCalculatorVisitor`.
**Justification:** Element classes only hold product state, while each Concrete Visitor is responsible for one specific business report across all menu types.

### 4. Minimal, well-justified encapsulation trade-offs
**Before:** Making fields `public` so external visitors can read them directly.
**After:** Keeping all fields `private final` and exposing only read-only getters (`getVolumeMl()`, `getWeightGrams()`).
**Justification:** Visitors require access to internal state to perform calculations. Using immutable `private final` fields with clean getters gives visitors necessary data without allowing them to mutate the elements.

### 5. Demonstrated extensibility (Open/Closed Principle)
**Before:** Modifying `MenuItem`, `BeverageItem`, and `PastryItem` every time a new report (like a discount export or allergen check) is needed.
**After:** Creating a new class implementing `MenuVisitor` without touching existing element classes.
**Justification:** Adding a third visitor (e.g., `DiscountExportVisitor`) requires zero changes to `BeverageItem` or `PastryItem`.