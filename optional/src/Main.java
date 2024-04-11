import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MemberDto foundMember = selectMember();
        System.out.println(foundMember.getMemberId());

        createOpt();

//        ================================================
//    옵셔널 객체의 메서드
//    옵셔널 객체는 값을 저장할 수 있으며, 저장한 값이 null인지 체크하거나, null이면 다른 값으로
//    대체해서 반환하는 등의 메서드를 지원한다.
        Optional<String> opt2 = createOpt2();

//        1.get()
//        옵셔널 객체에 저장된 값을 반환한다.
//        만약, null인 경우 예외가 발생된다.(NoSuchElementException)
//        String str = opt2.get();
//        System.out.println("str = " + str);

//        2. orElse(대체값)
//        옵셔널 객체에 저장된 값을 반환한다.
//        만약 null인 경우 [대체값]이 반환된다.
        String str = createOpt2().orElse("대체값");
        System.out.println("str = " + str);

//        3. orElseGet(람다식)
//        옵셔널 객체에 저장된 값을 반환한다.
//        만약 null인 경우 [람다식]의 결과가 반환된다.
        String str2 = createOpt2().orElseGet(() -> "람다식의 결과");
        System.out.println("str2 = " + str2);

//        4. orElseThrow(람다식)
//        옵셔널 객체에 저장된 값을 반환한다.
//        만약 null인 경우 [람다식]에서 반환하는 특정 예외를 발생시킨다. (자주 사용)
//        String str3 = createOpt2().orElseThrow(() -> new IllegalStateException("잘못된 회원 정보"));
//        System.out.println("str3 = " + str3);

//        5. isPresent()
//        옵셔널 객체에 저장된 값이 null이면 false
//        null이 아니면 true를 반환한다. (조건식)
        System.out.println(createOpt2().isPresent());
    }


    public static Optional<String> createOpt2(){
        Optional<String> opt = Optional.ofNullable(null);
        return opt;
    }


//    옵셔널 객체를 생성하는 방법 3가지
    public static void createOpt(){
//        1. empty()
//        비어있는 옵셔널 객체를 생성한다.
        Optional<Object> opt1 = Optional.empty();

//        2. of()
//        값을 저장하고 있는 옵셔널 객체를 생성한다.
//        단, 값이 확실하게 null이 아닌 경우에만 사용한다.
//        만약 null을 저장하면 NPE가 발생한다.
//        Optional<String> opt2 = Optional.of(null);

//        3. ofNullable()
//        값을 저장하고 있는 옵셔널 객체를 생성한다.
//        값이 null일 수도 있는 경우 사용한다.
        Optional<String> opt3 = Optional.ofNullable(null);
    }

    public static MemberDto selectMember(){
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(1L);
        memberDto.setName("홍길동");
        memberDto.setAge(22);

        return memberDto;
    }
}