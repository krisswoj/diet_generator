#include "rpn.hpp"

#include <functional>
#include <iostream>
#include <list>
#include <map>
#include <regex>
#include <vector>

using namespace std;

void rpn::put_op(const std::string& name,
    std::function<void(std::list<double>&)> f)
{
    ops[name] = f;
}

double rpn::count(const std::string& f)
{
    std::regex re(" ");
    std::sregex_token_iterator first{ f.begin(), f.end(), re, -1 }, last;
    std::vector<std::string> program_tokens{ first, last };
    list<double> mystack;
    for (string& t : program_tokens) {
        try {
            ops.at(t)(mystack);
        } catch (...) {
            try {
                mystack.push_back(stod(t));
            } catch (...) {
                throw invalid_argument(string("bad token: ") + t);
            }
        }
    }

    return mystack.back();
}

rpn::rpn()
{
    ops["+"] = [](auto& s) {
        auto a = s.back();
        s.pop_back();
        auto b = s.back();
        s.pop_back();
        auto c = a + b;
        s.push_back(c);
    };
    ops["-"] = [](auto& s) {
        auto a = s.back();
        s.pop_back();
        auto b = s.back();
        s.pop_back();
        auto c = b - a;
        s.push_back(c);
    };
    ops["*"] = [](auto& s) {
        auto a = s.back();
        s.pop_back();
        auto b = s.back();
        s.pop_back();
        auto c = a * b;
        s.push_back(c);
    };
    ops["/"] = [](auto& s) {
        auto a = s.back();
        s.pop_back();
        auto b = s.back();
        s.pop_back();
        auto c = b / a;
        s.push_back(c);
    };
}
