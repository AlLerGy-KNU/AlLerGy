# 3개의 값이 입력될 때 그 다음값을 예측하는 문제
# 3의 배수일 때는 Fizz, 5의 배수일 때는 Buzz, 
# 3의 배수이면서 동시에 5의 배수일 땐 FizzBuzz를 출력한다.
#
# 입력되는 값의 최종 숫자값을 찾고 그 값에서 1을 더한 값이
# 3의 배수 혹은 5의 배수 조건을 만족하는지 확인하는 문제이다.

index = 0

for _ in range(3):
    i = input()
    index += 1
    if i in "FizzBuzz":
        pass
    else:
        index = int(i)
index += 1
if index % 3 == 0 and index % 5 == 0:
    print("FizzBuzz")
elif index % 3 == 0:
    print("Fizz")
elif index % 5 == 0:
    print("Buzz")
else:
    print(index)
