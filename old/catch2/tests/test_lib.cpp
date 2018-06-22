#include "catch.hpp"

#include <rpn.hpp>

//using Catch::Matchers::EndsWith; // see "matchers"
using Catch::Matchers::Contains; // see "matchers"


TEST_CASE("Some test 2")
{
    REQUIRE((10 + 2) == 12);
    rpn testt = rpn();
    REQUIRE(testt.count("14296 10 +") == 14306);
    REQUIRE(testt.count("14296 10 -") == 14286);

    // (2 - 1 + 2) * (2 / 2)
    REQUIRE(testt.count("2 1 - 2 + 2 2 / *") == 3);
}

TEST_CASE("Error handling")
{
    rpn test = rpn();
    REQUIRE_THROWS_WITH(test.count("10 2 %"), Contains("%"));
}

SCENARIO("Simple scenario")
{
    GIVEN("there are numbers 10 and 20")
    {
        int x = 10, y = 20;
        WHEN("we add them")
        {
            int z = x + y;
            THEN("the result should be 30")
            {
                REQUIRE(z == 30);
            }
        }
    }
}
