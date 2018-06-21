#ifndef X___X_HPP__
#define X___X_HPP__

#include <functional>
#include <list>
#include <map>
#include <string>

class rpn {
protected:
    std::map<std::string,
        std::function<void(std::list<double>&)> >
        ops;

public:
    void put_op(const std::string& name,
        std::function<void(std::list<double>&)> f);
    double count(const std::string& f);
    rpn();
};

#endif
