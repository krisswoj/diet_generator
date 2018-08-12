describe("validator", function () {

    key_press = function(key) {
        element = document.getElementById('text');
        element.value = key;
        var evt = document.createEvent("HTMLEvents"); 
        evt.initEvent("input", false, true);
        element.dispatchEvent(evt);
        element.value = "";
    }

    beforeAll(function () {
        $('body').append(`
        <div id="name"><p>Krzysztof</p></div>
        <div id="number"><p>500700044</p></div>
        <div id="date">
            <p>30-09-1996</p>
            <p>09-30-1996</p></div>
        <div><label>Dozwolone cyfry</label><br/>
        <input type="text" id="text"></input></div>
        `);
    });
    
    it("invalid text", function () {
      $('#name').validate(/^[A-Za-z]+$/);
      expect($('#name').css("background-color")).toEqual("rgb(255, 0, 0)");
    });

    describe("A suite", function() {
        it("contains spec with an expectation", function() {
            expect(true).toBe(true);
        });
    });

    it("The 'toBe' matcher compares with ===", function() {
        var a = 12;
        var b = a;

        expect(a).toBe(b);
        expect(a).not.toBe(null);
    });

    it("The 'toBeLessThan' matcher is for mathematical comparisons", function() {
        var pi = 3.1415926,
            e = 2.78;

        expect(e).toBeLessThan(pi);
        expect(pi).not.toBeLessThan(e);
    });

    it("valid number", function () {
      $('#number').validate(/^\d+$/);
      expect($('#number').css("background-color")).toEqual("rgb(65, 105, 225)");
    });

    it("partialy valid date", function () {
        $('div#date > p').validate(/^((0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](?:19|20)\d\d)$/);
        expect($('div#date > p:nth-child(1)').css("background-color")).toEqual("rgb(65, 105, 225)");
        expect($('div#date > p:nth-child(2)').css("background-color")).toEqual("rgb(255, 0, 0)");
    });

    it("input validation", function() {
        var css = spyOn($.fn, 'css');
        $('#text').field_validation(/^[A-Za-z]+$/);

        key_press('aA');
        expect(css).toHaveBeenCalledWith("border", "2px solid green");
        key_press('1');
        expect(css).toHaveBeenCalledWith("border", "2px solid red");
    });
});
