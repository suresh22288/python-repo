import sys

# Check if a parameter is passed
if len(sys.argv) > 1:
    param = sys.argv[1]
    print("You entered:", param)
else:
    print("No parameter provided.")
