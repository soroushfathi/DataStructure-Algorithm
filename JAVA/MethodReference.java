public class MethodReference {
    interface FI{
        void show();
    }

    static class Test{
        public static void showMessage() {
            System.out.println("♥ for you");
        }
    }
    public static void main(String[] args) {
        FI fi = Test::showMessage;
        fi.show();
    }
}
