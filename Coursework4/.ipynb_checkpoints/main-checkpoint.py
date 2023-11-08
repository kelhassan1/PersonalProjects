SQFT_PER_GALLON = 350

def get_requirements():
    total_sqft = float(input("Enter total interior sqft: "))
    price_per_gallon = float(input("Enter price of paint per gallon ($): "))
    hourly_rate = float(input("Enter hourly painting rate per sq ft: "))
    return total_sqft, price_per_gallon, hourly_rate

def estimate_painting_cost(total_sqft, price_per_gallon):
    sqft_per_gallon = SQFT_PER_GALLON
    num_gallons = total_sqft / sqft_per_gallon
    paint_cost = num_gallons * price_per_gallon
    return paint_cost, num_gallons

def print_painting_estimate(total_sqft, sqft_per_gallon, num_gallons, price_per_gallon, hourly_rate):
    print(f"Total sqft:        {total_sqft:.2f}")
    print(f"Sqft per gallon:   {sqft_per_gallon}")
    print(f"Number of gallons: {num_gallons:.2f}")
    print(f"Price per gallon:  ${price_per_gallon:.2f}")
    print(f"Labor per sqft:    ${hourly_rate:.2f}")

def print_painting_percentage(paint_cost, labor_cost, total_cost):
    paint_percentage = (paint_cost / total_cost) * 100
    labor_percentage = (labor_cost / total_cost) * 100

    paint_percentage_str = '{:.2f}%'.format(paint_percentage)
    labor_percentage_str = '{:.2f}%'.format(labor_percentage)

    print(f"\n{'Cost':<20} {'Amount':<15} {'Percentage':<15}")
    print(f"{'Paint cost:':<20} ${paint_cost:.2f} {paint_percentage_str:>15}")
    print(f"Labor cost:        ${labor_cost:.2f} {labor_percentage_str:>15}")
    print(f"Total cost:        ${total_cost:.2f} {'100.00%':>15}")

def main():
    total_sqft, price_per_gallon, hourly_rate = get_requirements()

    paint_cost, num_gallons = estimate_painting_cost(total_sqft, price_per_gallon)
    labor_cost = hourly_rate * total_sqft

    total_cost = paint_cost + labor_cost

    print_painting_estimate(total_sqft, SQFT_PER_GALLON, num_gallons, price_per_gallon, hourly_rate)
    print_painting_percentage(paint_cost, labor_cost, total_cost)

if __name__ == "__main__":
    main()
